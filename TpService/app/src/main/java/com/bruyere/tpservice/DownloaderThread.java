package com.bruyere.tpservice;

import android.util.Log;

import java.util.concurrent.atomic.AtomicLong;

public class DownloaderThread extends Thread {

    public static final String DOWNLOADER = "DOWNLOADER";
    private AtomicLong increment = new AtomicLong(0);

    @Override
    public void run() {
        super.run();
        while (!isInterrupted()) {
            long current = increment.incrementAndGet();
            if (current % 100_000 == 0) {
                Log.d(DOWNLOADER, "Current = " + current);
            }
        }
    }

    public long getIncrement() {
        return increment.get();
    }
}
