package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final ImageView calendar = (ImageView) findViewById(R.id.calendar);
        final TextView month = (TextView) findViewById(R.id.month_text);

        backButton = findViewById(R.id.feb_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                calendar.setImageResource(R.drawable.feb_calendar);
                month.setText("February");
            }
        });

        nextButton = findViewById(R.id.mar_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                calendar.setImageResource(R.drawable.calendar);
                month.setText("March");
            }
        });

        pastButton = findViewById(R.id.pastReflection_button);
        pastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToReflection();

            }
        });
    }

    Button nextButton;
    Button backButton;
    Button pastButton;

    private void navigateToReflection() {
        Intent intent = new Intent(this, past_reflection.class);
        startActivity(intent);
    }

}
