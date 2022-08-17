package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class title_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_2);

        titleButton = findViewById(R.id.to_home);
        titleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on titleButton
                navigateToIntroScreen();

            }
        });
    }

    //Private Properties
    Button titleButton;

    //Private methods
    private void navigateToIntroScreen() {
        Intent intent = new Intent(this, intro_tutorial.class);
        startActivity(intent);
    }
}
