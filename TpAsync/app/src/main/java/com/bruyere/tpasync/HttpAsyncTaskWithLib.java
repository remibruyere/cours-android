package com.bruyere.tpasync;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpAsyncTaskWithLib extends AsyncTask<String, Void, User[]> {

    private Context context;
    private TextView textView;

    public HttpAsyncTaskWithLib(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected User[] doInBackground(String... strings) {
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

            User[] users = new Gson().fromJson(reader, User[].class);

            inputStream.close();
            conn.disconnect();

            return users;

        } catch (IOException e) {
            e.printStackTrace();
            //TODO : handle exception
        }

        return null;
    }

    @Override
    protected void onPostExecute(User[] users) {
        super.onPostExecute(users);
        textView.setText(users[0].toString());
    }
}
