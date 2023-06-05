package com.cansev.kaantigo_learncebuano.lesson;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

public class PersonalPronounTableFragment extends Fragment {


    private String selectedTheme;
    public PersonalPronounTableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_pronoun_table, container, false);
        applyTheme(view);
        return view;
    }

    private void applyTheme(View view) {
        TextView guide = view.findViewById(R.id.guide);
        TextView txt = view.findViewById(R.id.txt);
        FrameLayout frameLayout = view.findViewById(R.id.frameLayout);
        View divider = view.findViewById(R.id.divider);
        TableRow tableRow = view.findViewById(R.id.tableRow);

        switch (selectedTheme) {
            case "theme1":
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                guide.setTextColor(Color.WHITE);
                txt.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                tableRow.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                break;
            case "theme3":
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                guide.setTextColor(Color.WHITE);
                txt.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                tableRow.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                break;
            case "theme4":
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                guide.setTextColor(Color.WHITE);
                txt.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                tableRow.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                break;
        }
    }
}