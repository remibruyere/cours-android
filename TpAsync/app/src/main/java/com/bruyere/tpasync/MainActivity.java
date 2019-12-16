package com.bruyere.tpasync;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView counter = findViewById(R.id.counter);
        Button launchCounter = findViewById(R.id.launch_counter);

        launchCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void launchWithThread(TextView counter) {

    }

    private void launchWithAsyncTask(TextView counter) {

    }
}
