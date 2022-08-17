package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // Get intent that starts this activity
        Intent intent = getIntent();

        // Get shouldShow value from pond activity
        shouldShowMango = intent.getBooleanExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_MANGO, false);
        shouldShowNinja = intent.getBooleanExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_NINJA, false);
        shouldShowLilypad = intent.getBooleanExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_LILYPAD, false);
        shouldShowFlower = intent.getBooleanExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_FLOWER, false);

        flies = (TextView) findViewById(R.id.flies);
        flies.setText(String.valueOf(MainActivity.currency));


        // Match switches from XML to java switch
        mangoSwitch = (Switch) findViewById(R.id.mango_switch);
        ninjaSwitch = (Switch) findViewById(R.id.ninja_switch);
        lilypadSwitch = (Switch) findViewById(R.id.lilypad_switch);
        flowerSwitch = (Switch) findViewById(R.id.flower_switch);

        // Set value of switch
        mangoSwitch.setChecked(shouldShowMango);
        ninjaSwitch.setChecked(shouldShowNinja);
        lilypadSwitch.setChecked(shouldShowLilypad);
        flowerSwitch.setChecked(shouldShowFlower);

        mangoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shouldShowMango = true;
                }
                else {
                    shouldShowMango = false;
                }
            }
        });

        ninjaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shouldShowNinja = true;
                }
                else {
                    shouldShowNinja = false;
                }
            }
        });

        lilypadSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shouldShowLilypad = true;
                }
                else {
                    shouldShowLilypad = false;
                }
            }
        });

        flowerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shouldShowFlower = true;
                }
                else {
                    shouldShowFlower = false;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Intent that passes data back to pond after back button is pressed
        Intent intent = new Intent();
        intent.putExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_MANGO, shouldShowMango);
        intent.putExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_NINJA, shouldShowNinja);
        intent.putExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_LILYPAD, shouldShowLilypad);
        intent.putExtra(BasePageActivity.INTENT_KEY_SHOULD_DISPLAY_FLOWER, shouldShowFlower);

        // Set result to OK
        setResult(RESULT_OK, intent);
        finish();
    }

    private Switch mangoSwitch;
    private Boolean shouldShowMango;
    private Switch ninjaSwitch;
    private Boolean shouldShowNinja;
    private Switch lilypadSwitch;
    private Boolean shouldShowLilypad;
    private Switch flowerSwitch;
    private Boolean shouldShowFlower;
    private TextView flies;
}


