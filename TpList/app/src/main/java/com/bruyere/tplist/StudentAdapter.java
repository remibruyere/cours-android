package com.bruyere.tplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View studentRow = layoutInflater.inflate(R.layout.student_row, null);

        TextView lastName = studentRow.findViewById(R.id.lastName);
        TextView firstName = studentRow.findViewById(R.id.firstName);

        Student student = getItem(position);

        lastName.setText(student.getLastName());
        firstName.setText(student.getFirstName());

        return studentRow;
    }
}
