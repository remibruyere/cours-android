package com.bruyere.tpintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_FOR_SECOND = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSecond(view);
            }
        });
    }

    private void startSecond(View view) {
        String message = "Basic Message";
        Student student = new Student("Toto", "Titi");
        Book book = new Book("MyBook", 1, 1);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constant.PRIMITIF_KEY, message);
        intent.putExtra(Constant.SERIALIZABLE_KEY, student);
        intent.putExtra(Constant.PARCELABLE_KEY, book);
        startActivityForResult(intent, REQUEST_CODE_FOR_SECOND);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FOR_SECOND) {
            if (resultCode == RESULT_OK && data != null) {
                String message = data.getStringExtra(Constant.RETURN_KEY);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
