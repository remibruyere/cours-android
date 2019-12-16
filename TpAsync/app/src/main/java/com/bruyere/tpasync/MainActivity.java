package com.bruyere.tpasync;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView counter = findViewById(R.id.counter);
        Button launchCounter = findViewById(R.id.launch_counter);

        launchCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchWithAsyncTask(counter);
            }
        });
    }

    private void launchWithThread(final TextView counter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100_000_000; i++) {
                    final int curr = i;
                    if (i % 1000 == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                counter.setText(String.valueOf(curr));
                            }
                        });
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        counter.setText("Finish");
                    }
                });
            }
        }).start();
    }

    private void launchWithAsyncTask(TextView counter) {
        IncrementerAsyncTask incrementerAsyncTask = new IncrementerAsyncTask(this, counter);
        incrementerAsyncTask.execute(100_000_000L);
    }
}
