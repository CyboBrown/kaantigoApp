package com.cansev.kaantigo_learncebuano.navigation;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.ChangeClipBounds;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cansev.kaantigo_learncebuano.R;

public class ProfileTabFragment extends Fragment implements View.OnClickListener {

    public ProfileTabFragment() {
        // Required empty public constructor
    }

    Button btn_theme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);
        btn_theme = view.findViewById(R.id.btn_pref_themes);
        btn_theme.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pref_themes:
                Intent intent = new Intent(getActivity(), Themes.class);
                startActivity(intent);
        }
    }
}