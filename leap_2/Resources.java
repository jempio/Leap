package com.example.leap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Resources extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        Spinner spin = findViewById(R.id.spinner_1);
        String[] universities = {"Choose an Institution","SFU", "UBC", "Sprottshaw", "Langara", "BCIT", "KPU"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_spinner, universities);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                TextView textView1 = null;
                TextView textView3 = null;
                TextView textView5 = null;
                TextView textView7 = null;
                textView1 = (TextView)findViewById(R.id.textView1);
                textView3 = (TextView)findViewById(R.id.textView3);
                textView5 = (TextView)findViewById(R.id.textView5);
                textView7 = (TextView)findViewById(R.id.textView7);

                switch (position) {
                    case 0:
                        textView1.setText(" ");
                        textView3.setText(" ");
                        textView5.setText(" ");
                        textView7.setText(" ");
                        break;

                    case 1:
                        textView1.setText("1. Burnaby");
                        textView3.setText("#13-18");
                        textView5.setText("59%");
                        textView7.setText("$2,770 - 10,185");
                        break;

                    case 2:
                        textView1.setText("1. Vancouver\n2. Kelowna");
                        textView3.setText("#3");
                        textView5.setText("52.4% (2014)");
                        textView7.setText("$4,342 - 18,110");
                        break;

                    case 3:
                        textView1.setText("1. Richmond\n2. Kamloops");
                        textView3.setText("#178 in Canada");
                        textView5.setText("N/A");
                        textView7.setText("$3,300 - 28,647");
                        break;

                    case 4:
                        textView1.setText("1. Vancouver");
                        textView3.setText("#72");
                        textView5.setText("85% (2013)");
                        textView7.setText("$3,375 - 15,400");
                        break;

                    case 5:
                        textView1.setText("1. Richmond");
                        textView3.setText("#31");
                        textView5.setText("85%");
                        textView7.setText("$3,840 - 17,950");
                        break;

                    case 6:
                        textView1.setText("1. Richmond\n2. Kamloops\n3. Langley\n4. TECH \n5. Civic Plaza");
                        textView3.setText("#47");
                        textView5.setText("87%");
                        textView7.setText("Specific to University");
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Spinner spin2 = findViewById(R.id.spinner_2);
        String[] universities2 = {"Choose an Institution","SFU", "UBC", "Sprottshaw", "Langara", "BCIT", "KPU"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.custom_spinner, universities2);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spin2.setAdapter(adapter);

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                TextView textView2 = null;
                TextView textView4 = null;
                TextView textView6 = null;
                TextView textView8 = null;
                textView2 = (TextView) findViewById(R.id.textView2);
                textView4 = (TextView) findViewById(R.id.textView4);
                textView6 = (TextView) findViewById(R.id.textView6);
                textView8 = (TextView)findViewById(R.id.textView8);

                switch (position) {

                    case 0:
                        textView2.setText(" ");
                        textView4.setText(" ");
                        textView6.setText(" ");
                        textView8.setText(" ");
                        break;

                    case 1:
                        textView2.setText("1. Burnaby");
                        textView4.setText("#13-18");
                        textView6.setText("59%");
                        textView8.setText("$2,770 - 10,185");
                        break;

                    case 2:
                        textView2.setText("1. Vancouver\n2. Kelowna");
                        textView4.setText("#3");
                        textView6.setText("52.4% (2014)");
                        textView8.setText("$4,342 - 18,110");
                        break;

                    case 3:
                        textView2.setText("1. Richmond\n2. Kamloops");
                        textView4.setText("#178 in Canada");
                        textView6.setText("N/A");
                        textView8.setText("$3,300 - 28,647");
                        break;

                    case 4:
                        textView2.setText("1. Vancouver");
                        textView4.setText("#72");
                        textView6.setText("85% (2013)");
                        textView8.setText("$3,375 - 15,400");
                        break;

                    case 5:
                        textView2.setText("1. Richmond");
                        textView4.setText("#31");
                        textView6.setText("85%");
                        textView8.setText("$3,840 - 17,950");
                        break;

                    case 6:
                        textView2.setText("1. Richmond\n2. Kamloops\n3. Langley\n4. TECH \n5. Civic Plaza");
                        textView4.setText("#47");
                        textView6.setText("87%");
                        textView8.setText("Specific to University");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }




    // ignore
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
