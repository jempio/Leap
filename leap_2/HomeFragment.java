package com.example.leap_2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final ImageView smallWhiteRectangle1 = (ImageView) rootView.findViewById(R.id.smallWhiteRectangle);
        final ImageView mediumWhiteRectangle1 = (ImageView) rootView.findViewById(R.id.mediumWhiteRectangle);
        final ImageView largeWhiteRectangle1 = (ImageView) rootView.findViewById(R.id.whiteRectangle);
        final ConstraintLayout agendaRowOne = (ConstraintLayout) rootView.findViewById(R.id.agendaRow1);
        final ConstraintLayout agendaRowTwo = (ConstraintLayout) rootView.findViewById(R.id.agendaRow2);
        final Button buttonOneOne = (Button) rootView.findViewById(R.id.ButtonOneOne);
        final Button buttonOneTwo = (Button) rootView.findViewById(R.id.ButtonOneTwo);
        final Button buttonOneThree = (Button) rootView.findViewById(R.id.ButtonOneThree);
        final TextView arrayTextView1 = (TextView) rootView.findViewById(R.id.arrayTextView1);
        final TextView arrayTextView2 = (TextView) rootView.findViewById(R.id.arrayTextView2);
        final TextView arrayTextView3 = (TextView) rootView.findViewById(R.id.arrayTextView3);
        final ImageView greenLilypadHome = (ImageView) rootView.findViewById(R.id.greenLilypadHome);
        final ImageView redLilypadHome = (ImageView) rootView.findViewById(R.id.redLilypadHome);
        final ImageView yellowLilypadHome = (ImageView) rootView.findViewById(R.id.yellowLilypadHome);
        goalNameTextView = rootView.findViewById(R.id.goalName);
        pondButton = rootView.findViewById(R.id.homePondButton);
        pondButton.setOnClickListener(this);

        flies = (TextView) rootView.findViewById(R.id.flies);

        flies.setText(String.valueOf(MainActivity.currency));




        if (MainActivity.goalList != null) {
            for (Goal goal : MainActivity.goalList) {
                homeFragmentTaskArray.addAll(goal.taskItems);
                goalNameTextView.setText(goal.name);
                priority = goal.priority;
                if (priority == 1) {
                    greenLilypadHome.setVisibility(View.VISIBLE);
                    redLilypadHome.setVisibility(View.INVISIBLE);
                    yellowLilypadHome.setVisibility(View.INVISIBLE);
                }

                if (priority == 2){
                    yellowLilypadHome.setVisibility(View.VISIBLE);
                    greenLilypadHome.setVisibility(View.INVISIBLE);
                    redLilypadHome.setVisibility(View.INVISIBLE);
                }

                if (priority == 3){
                    yellowLilypadHome.setVisibility(View.INVISIBLE);
                    greenLilypadHome.setVisibility(View.INVISIBLE);
                    redLilypadHome.setVisibility(View.VISIBLE);
                }
            }
        }


        if (homeFragmentTaskArray.size() == 1) {
            smallWhiteRectangle1.setVisibility(View.VISIBLE);
            buttonOneOne.setVisibility(View.VISIBLE);
            String task1 = homeFragmentTaskArray.get(0).name;
            arrayTextView1.setText(task1);

        }
        if (homeFragmentTaskArray.size() == 2) {
            smallWhiteRectangle1.setVisibility(View.GONE);
            mediumWhiteRectangle1.setVisibility(View.VISIBLE);
            agendaRowOne.setVisibility(View.VISIBLE);
            buttonOneOne.setVisibility(View.VISIBLE);
            buttonOneTwo.setVisibility(View.VISIBLE);
            String task1 = homeFragmentTaskArray.get(0).name;
            arrayTextView1.setText(task1);
            String task2 = homeFragmentTaskArray.get(1).name;
            arrayTextView2.setText(task2);
        }
        if (homeFragmentTaskArray.size() == 3) {
            smallWhiteRectangle1.setVisibility(View.GONE);
            mediumWhiteRectangle1.setVisibility(View.GONE);
            largeWhiteRectangle1.setVisibility(View.VISIBLE);
            agendaRowOne.setVisibility(View.VISIBLE);
            agendaRowTwo.setVisibility(View.VISIBLE);
            buttonOneOne.setVisibility(View.VISIBLE);
            buttonOneTwo.setVisibility(View.VISIBLE);
            buttonOneThree.setVisibility(View.VISIBLE);
            String task1 = homeFragmentTaskArray.get(0).name;
            arrayTextView1.setText(task1);
            String task2 = homeFragmentTaskArray.get(1).name;
            arrayTextView2.setText(task2);
            String task3 = homeFragmentTaskArray.get(2).name;
            arrayTextView3.setText(task3);
        }


        return rootView;
    }
    private Integer priority;
    private TextView goalNameTextView;
    private Button pondButton;
    private ArrayList<Task> homeFragmentTaskArray = new ArrayList<>();
    private static final ArrayList<String> taskList = new ArrayList<String>();

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.homePondButton:
                fragment = new PondFragment();
                replaceFragment(fragment);
                break;
    }

       }
    public void replaceFragment(Fragment pondFragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, pondFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private TextView flies;
}
