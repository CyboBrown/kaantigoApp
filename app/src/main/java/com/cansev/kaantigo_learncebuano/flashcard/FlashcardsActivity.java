package com.cansev.kaantigo_learncebuano.flashcard;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.database.DatabaseAdapter;

import java.util.ArrayList;

public class FlashcardsActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Flashcard> flashcards;
    private String selectedTheme;
    ImageView flashcards_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        viewPager = findViewById(R.id.flashcardViewPager);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

        flashcards_back.setOnClickListener(view -> finish());

        DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
        flashcards = databaseAdapter.getFlashcards();

//        flashcards = new ArrayList<>();
//        flashcards.add(new Flashcard("Hello", "Kumusta"));
//        flashcards.add(new Flashcard("Goodbye", "Ari na ko"));
//        flashcards.add(new Flashcard("Please", "Palihog"));
//        flashcards.add(new Flashcard("Thank you", "Salamat"));
//        flashcards.add(new Flashcard("Yes", "Oo"));
//        flashcards.add(new Flashcard("No", "Dili"));

        FlashcardAdapter flashcardAdapter = new FlashcardAdapter(FlashcardsActivity.this, flashcards);

        viewPager.setAdapter(flashcardAdapter);

    }

    private void applyTheme() {
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        TextView topicName = findViewById(R.id.topicName);
        View divider = findViewById(R.id.divider);
        flashcards_back = findViewById(R.id.flashcards_back);
        switch (selectedTheme) {
            case "theme1":
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                topicName.setTextColor(Color.WHITE);
                flashcards_back.setColorFilter(Color.WHITE);
                break;
            case "theme3":
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                topicName.setTextColor(Color.WHITE);
                flashcards_back.setColorFilter(Color.WHITE);
                break;
            case "theme4":
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                topicName.setTextColor(Color.WHITE);
                flashcards_back.setColorFilter(Color.WHITE);
                break;
        }
    }
}

