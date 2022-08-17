package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tutorial1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial1);

        nextButton = findViewById(R.id.next_slide);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on titleButton
                navigateToNextScreen();

            }
        });
    }

    //Private Properties
    Button nextButton;

    //Private methods
    private void navigateToNextScreen() {
        Intent intent = new Intent(this, tutorial2.class);
        startActivity(intent);
    }
}
