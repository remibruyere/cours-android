package com.bruyere.tpservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static final String LIFE_CYCLE_CHECKER = "LIFE_CYCLE_CHECKER";
    private DownloaderThread downloaderThread;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        downloaderThread = new DownloaderThread();
        Log.d(LIFE_CYCLE_CHECKER, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!downloaderThread.isInterrupted()) {
            downloaderThread.interrupt();
        }
        Log.d(LIFE_CYCLE_CHECKER, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LIFE_CYCLE_CHECKER, "onStartCommand");
        downloaderThread.start();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LIFE_CYCLE_CHECKER, "onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LIFE_CYCLE_CHECKER, "onUnbind");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public long getCurrentIncrement() {
            return downloaderThread.getIncrement();
        }
    }
}
