package com.bruyere.tproom;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StudentDAO {
    @Insert
    void insert(Student student);

    @Query("SELECT * FROM STUDENT_TABLE WHERE lastName = :lastName")
    List<Student> getStudentsByLastName(String lastName);

    @Query("SELECT * FROM STUDENT_TABLE")
    LiveData<List<Student>> getAll();
}
