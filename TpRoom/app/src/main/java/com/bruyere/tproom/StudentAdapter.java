package com.bruyere.tproom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Student> students;

    public StudentAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = layoutInflater.inflate(R.layout.row, parent, false);
        return new StudentViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        if (students != null) {
            holder.textView.setText(students.get(position).getLastName());
        } else {
            holder.textView.setText("No data");
        }
    }

    @Override
    public int getItemCount() {
        return students == null ? 0 : students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
