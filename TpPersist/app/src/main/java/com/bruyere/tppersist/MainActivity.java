package com.bruyere.tppersist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREF = "my_pref";
    public static final String MY_DATE_KEY = "my_date_key";
    public static final String MY_CACHE_TXT = "/myCache.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readPref(View view) {
        SharedPreferences pref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        long myDate = pref.getLong(MY_DATE_KEY, -1);
        if (myDate == -1) {
            Toast.makeText(this, "Nothing !!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, new Date(myDate).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void writePref(View view) {
        SharedPreferences pref = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        pref.edit()
            .putLong(MY_DATE_KEY, new Date().getTime())
            .apply();
    }

    public void readCache(View view) {
        File cacheDir = getCacheDir();
        try {
            FileInputStream  fis = new FileInputStream(cacheDir.getPath()+ MY_CACHE_TXT);
            read(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeCache(View view) {
        File cacheDir = getCacheDir();
        try {
            FileOutputStream fos = new FileOutputStream(cacheDir.getPath()+ MY_CACHE_TXT);
            write(fos, "Cache me if you can !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile(View view) {

    }

    public void writeFile(View view) {

    }

    private void read(FileInputStream fis) {
        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }

    private void write(FileOutputStream fos, String toWrite) {
        try {
            fos.write(toWrite.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
