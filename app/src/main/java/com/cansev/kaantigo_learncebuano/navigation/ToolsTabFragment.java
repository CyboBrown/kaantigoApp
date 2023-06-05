package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.SentenceConstructorActivity;
import com.cansev.kaantigo_learncebuano.flashcard.FlashcardsActivity;
import com.google.android.material.card.MaterialCardView;

public class ToolsTabFragment extends Fragment implements View.OnClickListener {

    private String selectedTheme;
    public ToolsTabFragment() {
        // Required empty public constructor
    }

    CardView card_flashcards, card_sentence_constructor;

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
        View view = inflater.inflate(R.layout.fragment_tools_tab, container, false);

        applyTheme(view);

        card_flashcards = view.findViewById(R.id.card_flashcards);
        card_flashcards.setOnClickListener(this);
        card_flashcards.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        card_sentence_constructor = view.findViewById(R.id.card_sentence_constructor);
        card_sentence_constructor.setOnClickListener(this);
        card_sentence_constructor.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("Clicked");
        Intent intent;
        switch (view.getId()) {
            case R.id.card_flashcards:
                intent = new Intent(getActivity(), FlashcardsActivity.class);
                startActivity(intent);
                break;
            case R.id.card_sentence_constructor:
                intent = new Intent(getActivity(), SentenceConstructorActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void applyTheme(View view) {
        RelativeLayout relativeLayout = view.findViewById(R.id.relativeLayout2);
        TextView tools = view.findViewById(R.id.tools);
        MaterialCardView card_flashcards = view.findViewById(R.id.card_flashcards);
        MaterialCardView card_sentence_constructor = view.findViewById(R.id.card_sentence_constructor);
        TextView flashcards = view.findViewById(R.id.flashcards);
        TextView sentence_constructor = view.findViewById(R.id.sentence_constructor);
        TextView flashcards_desc = view.findViewById(R.id.flashcards_description);
        TextView sentence_constructor_desc = view.findViewById(R.id.sentence_constructor_description);
        View divider = view.findViewById(R.id.divider);
        ImageView thumbnail_flashcards = view.findViewById(R.id.thumbnail_flashcards);
        ImageView thumbnail_sentence_constructor = view.findViewById(R.id.thumbnail_sentence_constructor);

        switch(selectedTheme) {
            case "theme1":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                flashcards.setTextColor(Color.WHITE);
                sentence_constructor.setTextColor(Color.WHITE);
                flashcards_desc.setTextColor(Color.WHITE);
                sentence_constructor_desc.setTextColor(Color.WHITE);
                tools.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                thumbnail_flashcards.setColorFilter(Color.WHITE);
                thumbnail_sentence_constructor.setColorFilter(Color.WHITE);
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                card_sentence_constructor.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                break;
            case "theme3":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                flashcards.setTextColor(Color.WHITE);
                sentence_constructor.setTextColor(Color.WHITE);
                flashcards_desc.setTextColor(Color.WHITE);
                sentence_constructor_desc.setTextColor(Color.WHITE);
                tools.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                thumbnail_flashcards.setColorFilter(Color.WHITE);
                thumbnail_sentence_constructor.setColorFilter(Color.WHITE);
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                card_sentence_constructor.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                break;

            case "theme4":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                flashcards.setTextColor(Color.WHITE);
                sentence_constructor.setTextColor(Color.WHITE);
                flashcards_desc.setTextColor(Color.WHITE);
                sentence_constructor_desc.setTextColor(Color.WHITE);
                tools.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                thumbnail_flashcards.setColorFilter(Color.WHITE);
                thumbnail_sentence_constructor.setColorFilter(Color.WHITE);
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                card_sentence_constructor.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                break;
        }
//            case "theme3":
//                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
//                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
//                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
//                card_sentence_constructor.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
//                flashcards.setTextColor(Color.WHITE);
//                sentence_constructor.setTextColor(Color.WHITE);
//                flashcards_desc.setTextColor(Color.WHITE);
//                sentence_constructor_desc.setTextColor(Color.WHITE);
//                tools.setTextColor(Color.WHITE);
//                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
//                thumbnail_flashcards.setColorFilter(Color.WHITE);
//                thumbnail_sentence_constructor.setColorFilter(Color.WHITE);
//                break;
//            case "theme4":
//                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
//                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
//                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
//                card_sentence_constructor.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
//                flashcards.setTextColor(Color.WHITE);
//                sentence_constructor.setTextColor(Color.WHITE);
//                flashcards_desc.setTextColor(Color.WHITE);
//                sentence_constructor_desc.setTextColor(Color.WHITE);
//                tools.setTextColor(Color.WHITE);
//                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
//                thumbnail_flashcards.setColorFilter(Color.WHITE);
//                thumbnail_sentence_constructor.setColorFilter(Color.WHITE);
//                break;
//        }
    }
}