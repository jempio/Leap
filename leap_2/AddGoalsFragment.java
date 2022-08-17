
package com.example.leap_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddGoalsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_goals, container, false);

        Button active_button = (Button) view.findViewById(R.id.active_button);
        Button completed_button = (Button) view.findViewById(R.id.completed_button);

        final ImageView topbar = (ImageView) view.findViewById(R.id.topbar);
        final LinearLayout completed_layout = (LinearLayout) view.findViewById(R.id.completed_layout);
        final ConstraintLayout active_layout = (ConstraintLayout) view.findViewById(R.id.active_layout);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        final ImageView arthur = (ImageView) view.findViewById(R.id.arthur);
        final TextView arthur_text = (TextView) view.findViewById(R.id.arthur_text);
        flies = (TextView) view.findViewById(R.id.flies);


        flies.setText(String.valueOf(MainActivity.currency));

        completed_layout.setVisibility(View.GONE);
        active_layout.setVisibility(View.VISIBLE);

        // Create an empty array of Tasks and assign it the property taskItems
        consolidatedTaskItems = new ArrayList<Task>();


        // For each goal object in the MainActivity.goalList array copy of all of that goal's task items to our taskItems array
        if (MainActivity.goalList != null) {
            for (Goal goal : MainActivity.goalList) {
                consolidatedTaskItems.addAll(goal.taskItems);
                arthur.setVisibility(View.GONE);
                arthur_text.setVisibility(View.GONE);
            }
        }
            else {
                arthur.setVisibility(View.VISIBLE);
                arthur_text.setVisibility(View.VISIBLE);
            }

        // sort taskItems in the correct order, by priority


        adapter = new GoalAdapter(getActivity(), consolidatedTaskItems, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        active_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topbar.setImageResource(R.drawable.active_goals);
                completed_layout.setVisibility(View.GONE);
                active_layout.setVisibility(View.VISIBLE);
            }
        });

        completed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topbar.setImageResource(R.drawable.completed_goals);
                completed_layout.setVisibility(View.VISIBLE);
                active_layout.setVisibility(View.GONE);
            }
        });

        Button addGoalButton = (Button) view.findViewById(R.id.addGoalsButton);
        addGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAddGoalScreen();
            }
        });
        return view;
    }

    public void updateCurrency(){
        flies.setText(String.valueOf(MainActivity.currency));
    }

    private void navigateToAddGoalScreen() {
        Intent intent = new Intent(getActivity(), AddGoalActivity.class);
        startActivity(intent);
    }




    //Private properties
    private GoalAdapter adapter;
    private ArrayList<Task> consolidatedTaskItems;
    private RecyclerView recyclerView;
    private TextView flies;


}

