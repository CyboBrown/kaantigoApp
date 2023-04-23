package com.cansev.kaantigo_learncebuano.flashcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class FlashcardAdapter extends PagerAdapter {
    Context context;
    ArrayList<Flashcard> flashcards;
    LayoutInflater layoutInflater;

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
        MaterialCardView frontCardView = view.findViewById(R.id.frontText);
        MaterialCardView backCardView = view.findViewById(R.id.backText);

        TextView frontTextView = frontCardView.findViewById(R.id.frontTextView);
        TextView backTextView = backCardView.findViewById(R.id.backTextView);

        frontTextView.setText(flashcards.get(position).getFrontText());
        backTextView.setText(flashcards.get(position).getBackText());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
