package com.bruyere.tpfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public class MyFragment extends Fragment {

    public static final String LIFE_CYCLE_CHECKER = "LIFE_CYCLE_CHECKER";

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(LIFE_CYCLE_CHECKER, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LIFE_CYCLE_CHECKER, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(LIFE_CYCLE_CHECKER, "onCreateView");
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(LIFE_CYCLE_CHECKER, "onActivityCreated");
        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LIFE_CYCLE_CHECKER, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(LIFE_CYCLE_CHECKER, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(LIFE_CYCLE_CHECKER, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(LIFE_CYCLE_CHECKER, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(LIFE_CYCLE_CHECKER, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LIFE_CYCLE_CHECKER, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(LIFE_CYCLE_CHECKER, "onDetach");
    }

    public void changeText(String text) {
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(text);
    }

    // Tell activity call change text on all fragment but not me
    public void buttonClicked() {
        MyFragmentActivityInterface activity = (MyFragmentActivityInterface)getActivity();
        int myId = getId();
        activity.callOtherAndChange(myId);
    }

    public interface MyFragmentActivityInterface {
        void callOtherAndChange(int id);
    }
}
