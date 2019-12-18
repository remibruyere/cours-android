package com.bruyere.tpasync;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpAsyncTask extends AsyncTask<String, Long, String> {

    private Context context;
    private TextView textView;

    public HttpAsyncTask(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String urlString = strings[0];

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1_000);
            conn.setReadTimeout(10_000);
            conn.setRequestMethod("GET");

            conn.connect();

            int reponseCode = conn.getResponseCode();
            //TODO : Check response

            InputStream inputStream = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
                publishProgress((long) result.length());
            }

            inputStream.close();
            conn.disconnect();

            return result.toString();

        } catch (IOException e) {
            e.printStackTrace();
            //TODO : handle exception
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}
