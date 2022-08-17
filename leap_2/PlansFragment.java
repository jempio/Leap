package com.example.leap_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlansFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plans, container, false);
        flies = (TextView) view.findViewById(R.id.flies);

        flies.setText(String.valueOf(MainActivity.currency));

        Button postSecondaryButton = (Button) view.findViewById(R.id.postSecondaries_button);
        postSecondaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPostSecondaryPlans();
            }
        });
        return view;
    }
    private void navigateToPostSecondaryPlans(){
        Intent intent = new Intent(getActivity(), postSecondaryPlans.class);
        startActivity(intent);
    }

    private TextView flies;

}
