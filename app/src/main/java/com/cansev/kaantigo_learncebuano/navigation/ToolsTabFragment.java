package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.flashcard.FlashcardsActivity;

public class ToolsTabFragment extends Fragment implements View.OnClickListener {

    public ToolsTabFragment() {
        // Required empty public constructor
    }

    CardView card_flashcards;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools_tab, container, false);

        card_flashcards = view.findViewById(R.id.card_flashcards);
        card_flashcards.setOnClickListener(this);
        card_flashcards.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("Clicked");
        switch (view.getId()) {
            case R.id.card_flashcards:
                Intent intent = new Intent(getActivity(), FlashcardsActivity.class);
                startActivity(intent);
//            case R.id.card_sentence_constructor:
//                Intent intent = new Intent(getActivity(), SentenceConstructorActivity.class);
//                startActivity(intent);
        }
    }
}