package com.bruyere.tproom;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;
    private LiveData<List<Student>> allStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        allStudents = studentRepository.allStudents();
    }

    public LiveData<List<Student>> allStudents() {
        return allStudents;
    }

    public void insert(Student student) {
        studentRepository.insert(student);
    }
}
