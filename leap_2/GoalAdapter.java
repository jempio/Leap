package com.example.leap_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {

    private ArrayList<Task> taskItems;
    private LayoutInflater inflater;
    private AddGoalsFragment addGoalsFragment;

    public GoalAdapter(Context ct, ArrayList<Task> taskItems, AddGoalsFragment addGoalsFragment) {
        inflater = LayoutInflater.from(ct);
        this.taskItems = taskItems;
        this.addGoalsFragment = addGoalsFragment;
    }


    @NonNull
    @Override
    public GoalAdapter.GoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.goal_item, parent, false);
        GoalViewHolder viewHolder = new GoalAdapter.GoalViewHolder(itemView, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoalAdapter.GoalViewHolder holder, int position) {
        Task task = taskItems.get(position);
        holder.populateDisplay(task);
    }

    @Override
    public int getItemCount() {
        return (taskItems == null) ? 0 : taskItems.size();    }


    public class GoalViewHolder extends RecyclerView.ViewHolder{
        private Button taskButtonView;
        private Button circle1;
        public GoalAdapter adapter;


        public GoalViewHolder(@NonNull final View itemView, GoalAdapter adapter) {
            super(itemView);
            taskButtonView = itemView.findViewById(R.id.task1);
            taskButtonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    circle1.setBackgroundResource(R.drawable.check_circle);
                    Toast.makeText(itemView.getContext(), "Nice! You just gained 50 flies!", Toast.LENGTH_SHORT).show();
                    MainActivity.currency += 50;
                    addGoalsFragment.updateCurrency();
                }
            });
            circle1 = itemView.findViewById(R.id.circle1);
            this.adapter = adapter;



        }

        public void populateDisplay(Task task) {
            if (task != null) {
                taskButtonView.setText((CharSequence) task.name);

            }
        }
    }




}


