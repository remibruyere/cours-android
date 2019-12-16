package com.bruyere.tpservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isBound = false;
    private MyService.MyBinder myBinder;
    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            isBound = true;
            myBinder = (MyService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
            myBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(view);
            }
        });
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop(view);
            }
        });
        findViewById(R.id.bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind(view);
            }
        });
        findViewById(R.id.unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbind(view);
            }
        });
    }

    private void start(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    private void stop(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private void bind(View view) {
        if (!isBound) {
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, sc, BIND_AUTO_CREATE);
        } else {
            String message = "Current = " + myBinder.getCurrentIncrement();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    private void unbind(View view) {
        if (isBound) {
            unbindService(sc);
            isBound = false;
        }
    }

}
