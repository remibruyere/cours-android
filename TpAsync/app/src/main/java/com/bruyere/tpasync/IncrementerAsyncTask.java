package com.bruyere.tpasync;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class IncrementerAsyncTask extends AsyncTask<Long, Long, String> {

    private Context context;
    private TextView counter;

    public IncrementerAsyncTask(Context context, TextView counter) {
        this.context = context;
        this.counter = counter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        counter.setText("STARTED");
    }

    @Override
    protected String doInBackground(Long... longs) {
        long maxVal = longs[0];
        for (long i = 0; i < maxVal; i++) {
            if (i % 1000 == 0) {
                publishProgress(i);
            }
        }
        return "Finish";
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        counter.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        counter.setText(s);
    }
}
