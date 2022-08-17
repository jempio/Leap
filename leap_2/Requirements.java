package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requirements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);


        saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on button

                Goal myGoal = new Goal();
                myGoal.name = "Select High School Courses";
                myGoal.priority = 1;
                myGoal.taskItems = taskArrayList;

                Task task1 = new Task();
                task1.name = "Consult university websites and go to admission requirements";
                taskArrayList.add(task1);

                Task task2 = new Task();
                task2.name = "Choose a program you are interested in";
                taskArrayList.add(task2);

                Task task3 = new Task();
                task3.name = "Review the admission requirements for  that program of study";
                taskArrayList.add(task3);

                Task task4 = new Task();
                task4.name = "Make a course plan of the courses that you need to take to get into the specific program(s) of your choice";
                taskArrayList.add(task4);

                Task task5 = new Task();
                task5.name = "When choosing high school courses, select ones that pertain to what you need for university";
                taskArrayList.add(task5);



                MainActivity.goalList = new ArrayList<>();
                MainActivity.goalList.add(myGoal);


                navigateToHome();

            }
        });
    }

    Button saveButton;
    private ArrayList<Task> taskArrayList = new ArrayList<Task>();


    private void navigateToHome(){
        Intent intent = new Intent(this, BasePageActivity.class);
        startActivity(intent);


    }
}
