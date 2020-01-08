package com.bruyere.tproom;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAdapter studentAdapter = new StudentAdapter(this);
        recyclerView.setAdapter(studentAdapter);

        final StudentViewModel studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                int i = new Random().nextInt();
                student.setFirstName("Toto_" + i);
                student.setLastName("TITI_" + i);
                studentViewModel.insert(student);
            }
        });
    }
}
