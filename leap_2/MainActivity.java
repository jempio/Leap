package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    RecyclerView recyclerView;

    public static ArrayList<Goal> goalList;
    public static ArrayList<Goal> taskItems;
    public static Integer currency = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent title_2Intent = new Intent(MainActivity.this, title_2.class);
                startActivity(title_2Intent);
                finish();

            }
        }, SPLASH_TIME_OUT);



    }

}