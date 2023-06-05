package com.cansev.kaantigo_learncebuano.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

public class QuizResults extends AppCompatActivity {

    private String selectedTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

        final MaterialCardView btn_b2quiz = findViewById(R.id.btn_b2quiz);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getInCorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        correctAnswers.setText("Correct Answers: " + String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText("Incorrect Answers: " + String.valueOf(getInCorrectAnswers));

        btn_b2quiz.setOnClickListener(view -> finish());
    }

    private void applyTheme() {
        ConstraintLayout resultPage = findViewById(R.id.resultPage);
        MaterialCardView card_quiz_result = findViewById(R.id.card_quiz_result);
        TextView textView12 = findViewById(R.id.textView12);
        TextView correctAnswers = findViewById(R.id.correctAnswers);
        TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);
        MaterialCardView btn_b2quiz = findViewById(R.id.btn_b2quiz);
        TextView backToHome = findViewById(R.id.backToHome);
        switch (selectedTheme) {
            case "theme1":
                resultPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                card_quiz_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                textView12.setTextColor(Color.WHITE);
                correctAnswers.setTextColor(Color.WHITE);
                incorrectAnswers.setTextColor(Color.WHITE);
                btn_b2quiz.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                backToHome.setTextColor(Color.WHITE);
                break;
            case "theme3":
                resultPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                card_quiz_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                textView12.setTextColor(Color.WHITE);
                correctAnswers.setTextColor(Color.WHITE);
                incorrectAnswers.setTextColor(Color.WHITE);
                btn_b2quiz.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                backToHome.setTextColor(Color.WHITE);
                break;
            case "theme4":
                resultPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                card_quiz_result.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                textView12.setTextColor(Color.WHITE);
                correctAnswers.setTextColor(Color.WHITE);
                incorrectAnswers.setTextColor(Color.WHITE);
                btn_b2quiz.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                backToHome.setTextColor(Color.WHITE);
                break;
        }
    }
}