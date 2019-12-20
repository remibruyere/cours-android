package com.bruyere.tproom;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class StudentRepository {
    private StudentDAO studentDAO;
    private LiveData<List<Student>> allStudents;

    public StudentRepository(Context context) {
        MyDatabase database = MyDatabase.getInstance(context);
        studentDAO = database.studentDAO();
        allStudents = studentDAO.getAll();
    }

    public LiveData<List<Student>> allStudents() {
        return allStudents;
    }

    public void insert(Student student) {
        new InsertAsyncTask(studentDAO).execute(student);
    }

    public static class InsertAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDAO studentDAO;

        public InsertAsyncTask(StudentDAO studentDAO) {
            this.studentDAO = studentDAO;
        }

        @Override
        protected Void doInBackground(Student... students) {
            for (Student student : students) {
                studentDAO.insert(student);
            }
            return null;
        }
    }
}
