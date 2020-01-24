package com.bruyere.tptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.IconCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IComparator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });
    }

    private void buttonClicked() {
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView textView = findViewById(R.id.textView);
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        textView.setText(isEqual(text1, text2)? "OK": "NOT OK");
    }

    @Override
    public boolean isEqual(String text1, String text2) {
        return (text1 != null)?text1.equalsIgnoreCase(text2): text1 == text2;
    }
}
