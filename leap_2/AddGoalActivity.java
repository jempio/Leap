package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AddGoalActivity extends AppCompatActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        addGoalEditText = findViewById(R.id.addGoalEditText);
        addGoalEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    addGoalEditText.clearFocus();
                    return true;
                }
                return false;
            }
        });


        row1EditText = findViewById(R.id.row1_edit_text);
        row1EditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Task task = new Task();
                    task.name = row1EditText.getText().toString();
                    taskArrayList.add(task);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    row1EditText.clearFocus();
                    return true;
                }
                return false;
            }
        });
        row2EditText = findViewById(R.id.row2_edit_text);
        row2EditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Task task = new Task();
                    task.name = row2EditText.getText().toString();
                    taskArrayList.add(task);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    row2EditText.clearFocus();
                    return true;
                }
                return false;
            }
        });
        row3EditText = findViewById(R.id.row3_edit_text);
        row3EditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Task task = new Task();
                    task.name = row3EditText.getText().toString();
                    taskArrayList.add(task);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    row3EditText.clearFocus();
                    return true;
                }
                return false;
            }
        });

        final Button redLilyPad = findViewById(R.id.redLilypadDisabled);
        final Button yellowLilyPad = findViewById(R.id.yellowLilypadDisabled);
        final Button greenLilyPad = findViewById(R.id.greenLilypadDisabled);
        redLilyPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                redLilyPad.setSelected(true);
                redLilyPad.setPressed(false);
                yellowLilyPad.setSelected(false);
                greenLilyPad.setSelected(false);
                Toast.makeText(AddGoalActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                priority = 3;
            }
        });

        yellowLilyPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                yellowLilyPad.setSelected(true);
                yellowLilyPad.setPressed(false);
                redLilyPad.setSelected(false);
                greenLilyPad.setSelected(false);
                Toast.makeText(AddGoalActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                priority = 2;

            }
        });

        greenLilyPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                greenLilyPad.setSelected(true);
                greenLilyPad.setPressed(false);
                yellowLilyPad.setSelected(false);
                redLilyPad.setSelected(false);
                Toast.makeText(AddGoalActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                priority = 1;
            }
        });


        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = addGoalEditText.getText().toString();
                if (name == null || name.isEmpty()) {
                    Toast.makeText(AddGoalActivity.this, "You have to type in a Goal!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Goal myGoal = new Goal();
                myGoal.name = name;
                myGoal.priority = priority;
                myGoal.taskItems = taskArrayList;
                MainActivity.goalList = new ArrayList<>();
                MainActivity.goalList.add(myGoal);
                Collections.sort(MainActivity.goalList, new Comparator<Goal>() {
                    @Override
                    public int compare( Goal lhs, Goal rhs) {
                        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                        return lhs.priority > rhs.priority ? -1 : (lhs.priority < rhs.priority) ? 1 : 0;
                    }
                });
                navigateToGoalScreen();
            }
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGoalScreen();
            }
        });
        setupTaskListContainer();
    }
    public ImageButton saveButton;
    private ImageButton cancelButton;
    private ArrayList<Task> taskArrayList = new ArrayList<Task>();
    private ConstraintLayout row1Container;
    private ConstraintLayout row2Container;
    private ConstraintLayout row3Container;
    private EditText row1EditText;
    private EditText row2EditText;
    private EditText row3EditText;
    private EditText addGoalEditText;
    private Integer priority;
    private void navigateToGoalScreen() {
        Intent intent = new Intent(this, BasePageActivity.class);
        startActivity(intent);
    }

    private void setupTaskListContainer() {
        row1Container = findViewById(R.id.row1);
        row2Container = findViewById(R.id.row2);
        row3Container = findViewById(R.id.row3);
        row1EditText = findViewById(R.id.row1_edit_text);
        row2EditText = findViewById(R.id.row2_edit_text);
        row3EditText = findViewById(R.id.row3_edit_text);

        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTaskButtonTapped();
            }
        });
    }

    private void addTaskButtonTapped() {
        // TODO: check how many items in taskArrayList, and show the correct row
        if (taskArrayList.size() == 0) {
            // Make a row visible
            row1Container.setVisibility(View.VISIBLE);
            // Move cursor to this edit text, keyboard should appear
            row1EditText.requestFocus();
        }
        else if (taskArrayList.size() == 1) {
            row2Container.setVisibility(View.VISIBLE);
            row2EditText.requestFocus();
        }
        else if (taskArrayList.size() == 2) {
            row3Container.setVisibility(View.VISIBLE);
            row3EditText.requestFocus();
        }

    }


}






