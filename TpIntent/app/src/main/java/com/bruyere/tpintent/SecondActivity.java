package com.bruyere.tpintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMainActivity(view);
            }
        });

        String message = getIntent().getStringExtra(Constant.PRIMITIF_KEY);

        Student student = (Student) getIntent().getSerializableExtra(Constant.SERIALIZABLE_KEY);

        Book book = getIntent().getParcelableExtra(Constant.PARCELABLE_KEY);

        Toast.makeText(this, book.toString(), Toast.LENGTH_SHORT).show();
    }

    private void goBackToMainActivity(View view) {
        String returnMessage = "Return Message";
        Intent intent = new Intent();
        intent.putExtra(Constant.RETURN_KEY, returnMessage);
        setResult(RESULT_OK, intent);
        finish();
    }
}
