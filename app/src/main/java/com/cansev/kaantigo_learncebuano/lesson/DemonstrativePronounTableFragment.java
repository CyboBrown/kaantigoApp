package com.cansev.kaantigo_learncebuano.lesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cansev.kaantigo_learncebuano.R;

public class DemonstrativePronounTableFragment extends Fragment {

    public DemonstrativePronounTableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demonstrative_pronoun_table, container, false);
    }
}