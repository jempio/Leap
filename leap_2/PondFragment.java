package com.example.leap_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;

public class PondFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public void updateMangoVisibility() {
        if (mango != null) {
            // Changes visibility of mango based on shouldDisplay boolean
            if (BasePageActivity.basePageActivity.shouldDisplayMango) {
                mango.setVisibility(View.VISIBLE);
            }
            else {
                mango.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void updateNinjaVisibility() {
        if (ninja != null) {
            // Changes visibility of ninja based on shouldDisplay boolean
            if (BasePageActivity.basePageActivity.shouldDisplayNinja) {
                ninja.setVisibility(View.VISIBLE);
            }
            else {
                ninja.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void updateLilypadVisibility() {
        if (lilypads != null) {
            // Changes visibility of ninja based on shouldDisplay boolean
            if (BasePageActivity.basePageActivity.shouldDisplayLilypad) {
                lilypads.setVisibility(View.VISIBLE);
            }
            else {
                lilypads.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void updateFlowerVisibility() {
        if (flowers != null) {
            // Changes visibility of ninja based on shouldDisplay boolean
            if (BasePageActivity.basePageActivity.shouldDisplayFlower) {
                flowers.setVisibility(View.VISIBLE);
            }
            else {
                flowers.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_pond, container, false);
        mango = view.findViewById(R.id.mango);
        ninja = view.findViewById(R.id.ninja);
        lilypads = view.findViewById(R.id.lilypads);
        flowers = view.findViewById(R.id.pinkflowers);

        Button shopButton = (Button) view.findViewById(R.id.shop_button);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner_bg);
        String[] backgrounds = {"Day", "Night", "Sunset", "Magical"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.custom_spinner, backgrounds);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spin.setAdapter(adapter);

        final GifImageView gif = (GifImageView) view.findViewById(R.id.gifImageView);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        gif.setBackgroundResource(R.drawable.pond_bg);
                        break;

                    case 1:
                        //Default image
                        gif.setBackgroundResource(R.drawable.pond_night);
                        break;

                    case 2:
                        //Default image
                        gif.setBackgroundResource(R.drawable.pond_sunset);
                        break;

                    case 3:
                        //Default image
                        gif.setBackgroundResource(R.drawable.pond_magic);
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToShop();
            }
        });


        // Sets visibility of frogs based on switches from shop
        updateMangoVisibility();
        updateNinjaVisibility();
        updateLilypadVisibility();
        updateFlowerVisibility();

        return view;
    }

    private ImageView mango = null;
    private ImageView ninja = null;
    private ImageView lilypads = null;
    private ImageView flowers = null;

    private void navigateToShop() {
        BasePageActivity.basePageActivity.navigateToShop();
    }

// does nothing
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

