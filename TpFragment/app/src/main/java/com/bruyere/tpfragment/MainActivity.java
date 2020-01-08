package com.bruyere.tpfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentActivityInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager fn = getSupportFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();
        ft.replace(R.id.fragment_place, new MyFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void callOtherAndChange(int id) {
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragments = fm.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment.getId() != id) {
                ((MyFragment)fragment).changeText(new Date().toString());
            }
        }
    }
}
