package com.cansev.kaantigo_learncebuano.flashcard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.cansev.kaantigo_learncebuano.R;

import java.util.ArrayList;

public class FlashcardsActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Flashcard> flashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        viewPager = findViewById(R.id.flashcardViewPager);

        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Hello", "Kumusta"));
        flashcards.add(new Flashcard("Goodbye", "Paalam"));
        flashcards.add(new Flashcard("Please", "Palihog"));
        flashcards.add(new Flashcard("Thank you", "Salamat"));
        flashcards.add(new Flashcard("Yes", "Oo"));
        flashcards.add(new Flashcard("No", "Dili"));

        FlashcardAdapter flashcardAdapter = new FlashcardAdapter(FlashcardsActivity.this, flashcards);

        viewPager.setAdapter(flashcardAdapter);

    }
}

