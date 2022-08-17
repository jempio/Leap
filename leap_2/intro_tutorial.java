package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intro_tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_tutorial);

        nextButton = findViewById(R.id.next_slide);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on titleButton
                navigateToNextScreen();

            }
        });

        skipButton = findViewById(R.id.skip_button);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on titleButton
                navigateToHome();

            }
        });
    }

    //Private Properties
    Button nextButton;
    Button skipButton;

    //Private methods
    private void navigateToNextScreen() {
        Intent intent = new Intent(this, tutorial1.class);
        startActivity(intent);
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, BasePageActivity.class);
        startActivity(intent);
    }
}
