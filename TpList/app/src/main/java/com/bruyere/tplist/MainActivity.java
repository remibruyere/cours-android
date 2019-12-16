package com.bruyere.tplist;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private final static String[] days = {
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setListAdapter(buildDayAdapter());
        setListAdapter(buildStudentAdapter());
    }

    private ArrayAdapter<String> buildDayAdapter() {
        return new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                days
        );
    }

    private ArrayAdapter<Student> buildStudentAdapter() {
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            studentList.add(new Student("LAST_" + i, "FIRST_" + i));
        }

        return new StudentAdapter(this, studentList);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object obj = getListAdapter().getItem(position);

        Toast.makeText(this, obj.toString(), Toast.LENGTH_SHORT).show();
    }
}
