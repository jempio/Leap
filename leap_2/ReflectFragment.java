package com.example.leap_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReflectFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reflect, container, false);

        final Button epic = view.findViewById(R.id.epic);
        final Button happy = view.findViewById(R.id.happy);
        final Button neutral = view.findViewById(R.id.neutral);
        final Button sad = view.findViewById(R.id.sad);
        final Button tired = view.findViewById(R.id.tired);
        final ImageView calendar = view.findViewById(R.id.calendar_icon);
        flies = (TextView) view.findViewById(R.id.flies);


        flies.setText(String.valueOf(MainActivity.currency));

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCalendar();
            }
        });

        epic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                epic.setSelected(true);
                epic.setPressed(false);
                happy.setSelected(false);
                neutral.setSelected(false);
                sad.setSelected(false);
                tired.setSelected(false);
            }
        });

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                happy.setSelected(true);
                happy.setPressed(false);
                epic.setSelected(false);
                neutral.setSelected(false);
                sad.setSelected(false);
                tired.setSelected(false);
            }
        });

        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                neutral.setSelected(true);
                neutral.setPressed(false);
                epic.setSelected(false);
                happy.setSelected(false);
                sad.setSelected(false);
                tired.setSelected(false);
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                sad.setSelected(true);
                sad.setPressed(false);
                epic.setSelected(false);
                happy.setSelected(false);
                neutral.setSelected(false);
                tired.setSelected(false);
            }
        });

        tired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(false);
                v.setPressed(false);
                tired.setSelected(true);
                tired.setPressed(false);
                epic.setSelected(false);
                happy.setSelected(false);
                neutral.setSelected(false);
                sad.setSelected(false);
            }
        });

        Button saveButton = (Button) view.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Reflection saved!", Toast.LENGTH_SHORT).show();
                navigateToHome();
            }
        });



        return view;


    }

    private void navigateToHome(){
        Intent intent = new Intent(getActivity(), BasePageActivity.class);
        startActivity(intent);
    }

    private void navigateToCalendar(){
        Intent intent = new Intent(getActivity(), calendar.class);
        startActivity(intent);
    }
    private TextView flies;

}

