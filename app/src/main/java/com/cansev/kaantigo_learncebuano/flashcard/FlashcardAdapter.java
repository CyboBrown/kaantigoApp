package com.cansev.kaantigo_learncebuano.flashcard;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class FlashcardAdapter extends PagerAdapter {
    Context context;
    ArrayList<Flashcard> flashcards;
    LayoutInflater layoutInflater;
    private String selectedTheme;

    public FlashcardAdapter(Context context, ArrayList<Flashcard> flashcards) {
        this.context = context;
        this.flashcards = flashcards;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return flashcards.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.flashcard_item, container, false);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(container.getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        MaterialCardView frontCardView = view.findViewById(R.id.frontText);
        MaterialCardView backCardView = view.findViewById(R.id.backText);

        TextView frontTextView = frontCardView.findViewById(R.id.frontTextView);
        TextView backTextView = backCardView.findViewById(R.id.backTextView);

        frontTextView.setText(flashcards.get(position).getFrontText());
        backTextView.setText(flashcards.get(position).getBackText());

        applyTheme(view, container);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    private void applyTheme(View view, ViewGroup container) {

        MaterialCardView frontCardView = view.findViewById(R.id.frontText);
        MaterialCardView backCardView = view.findViewById(R.id.backText);

        TextView frontTextView = frontCardView.findViewById(R.id.frontTextView);
        TextView backTextView = backCardView.findViewById(R.id.backTextView);

        switch(selectedTheme) {
            case "theme1":
                view.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.darkBlack));
                frontCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightBlack));
                backCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightBlack));
                frontTextView.setTextColor(Color.WHITE);
                backTextView.setTextColor(Color.WHITE);
                break;
            case "theme3":
                view.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightGreenDark));
                frontCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightGreenLight));
                backCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightGreenLight));
                frontTextView.setTextColor(Color.WHITE);
                backTextView.setTextColor(Color.WHITE);
                break;
            case "theme4":
                view.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightBlueDark));
                frontCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightBlueLight));
                backCardView.setCardBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.lightBlueLight));
                frontTextView.setTextColor(Color.WHITE);
                backTextView.setTextColor(Color.WHITE);
                break;
        }
    }
}
