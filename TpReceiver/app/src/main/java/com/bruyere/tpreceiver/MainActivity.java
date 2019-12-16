package com.bruyere.tpreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String CUSTOM_ACTION = "com.bruyere.tpreceiver.CUSTOM_ACTION";
    private MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.explicit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explicit(view);
            }
        });
        findViewById(R.id.implicit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                implicit(view);
            }
        });

        registerReceiver(myReceiver, new IntentFilter(CUSTOM_ACTION));
        registerReceiver(myReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    private void explicit(View view) {
        Intent intent = new Intent(this, MyReceiver.class);
        sendBroadcast(intent);
    }

    private void implicit(View view) {
        Intent intent = new Intent(CUSTOM_ACTION);
        sendBroadcast(intent);
    }
}
