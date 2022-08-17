package com.example.leap_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BasePageActivity extends AppCompatActivity {

    public static BasePageActivity basePageActivity = null;
    public Boolean shouldDisplayMango = false;
    public Boolean shouldDisplayNinja = false;
    public Boolean shouldDisplayLilypad = false;
    public Boolean shouldDisplayFlower = false;

    final public static String INTENT_KEY_SHOULD_DISPLAY_MANGO = "shouldDisplayMango";
    final public static String INTENT_KEY_SHOULD_DISPLAY_NINJA = "shouldDisplayNinja";
    final public static String INTENT_KEY_SHOULD_DISPLAY_LILYPAD = "shouldDisplayLilypad";
    final public static String INTENT_KEY_SHOULD_DISPLAY_FLOWER = "shouldDisplayFlower";

    public void navigateToShop() {
        Intent intent = new Intent (this, ShopActivity.class);
        intent.putExtra(INTENT_KEY_SHOULD_DISPLAY_MANGO, shouldDisplayMango);
        intent.putExtra(INTENT_KEY_SHOULD_DISPLAY_NINJA, shouldDisplayNinja);
        intent.putExtra(INTENT_KEY_SHOULD_DISPLAY_LILYPAD, shouldDisplayLilypad);
        intent.putExtra(INTENT_KEY_SHOULD_DISPLAY_FLOWER, shouldDisplayFlower);
        startActivityForResult(intent, LAUNCH_SHOP_ACTIVITY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_page);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        basePageActivity = this;
    }



    // Method called when an activity started is completed and we return to this activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Tells us the activity we are returning from
        if (requestCode == LAUNCH_SHOP_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                // Read shouldDisplay value from data returned by shop activity
                shouldDisplayMango = data.getBooleanExtra(INTENT_KEY_SHOULD_DISPLAY_MANGO, false);
                shouldDisplayNinja = data.getBooleanExtra(INTENT_KEY_SHOULD_DISPLAY_NINJA, false);
                shouldDisplayLilypad = data.getBooleanExtra(INTENT_KEY_SHOULD_DISPLAY_LILYPAD, false);
                shouldDisplayFlower = data.getBooleanExtra(INTENT_KEY_SHOULD_DISPLAY_FLOWER, false);
                if (pondFragment != null) {
                    // Update the frog visibility
                    pondFragment.updateMangoVisibility();
                    pondFragment.updateNinjaVisibility();
                    pondFragment.updateLilypadVisibility();
                    pondFragment.updateFlowerVisibility();
                }
            }
        }
    }

    final private int LAUNCH_SHOP_ACTIVITY = 1001;
    private PondFragment pondFragment = null;
    private HomeFragment homeFragment = null;

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            pondFragment = null;
                            break;
                        case R.id.nav_reflect:
                            selectedFragment = new ReflectFragment();
                            pondFragment = null;
                            break;
                        case R.id.nav_addGoal:
                            selectedFragment = new AddGoalsFragment();
                            pondFragment = null;
                            break;
                        case R.id.nav_plans:
                            selectedFragment = new PlansFragment();
                            pondFragment = null;
                            break;
                        case R.id.nav_pond:
                            pondFragment = new PondFragment();
                            selectedFragment = pondFragment;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

}
