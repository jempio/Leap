package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class postSecondaryPlans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postsecondary_plans);

        planButton = findViewById(R.id.goalPlan1);
        planButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User taps on button
                navigateToRequirements();

            }
        });

        resourcesButton = findViewById(R.id.resources3);
        resourcesButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                navigateToResources();
            }
        });
    }

    // Private Properties
    Button planButton;
    Button resourcesButton;
    // Private Methods

    private void navigateToRequirements(){
        Intent intent = new Intent(this, Requirements.class);
        startActivity(intent);
    }

    private void navigateToResources(){
        Intent intent = new Intent(this, Resources.class);
        startActivity(intent);
    }

}
