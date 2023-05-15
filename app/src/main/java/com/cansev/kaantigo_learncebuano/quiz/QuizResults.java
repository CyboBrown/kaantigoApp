package com.cansev.kaantigo_learncebuano.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final MaterialCardView btn_b2quiz = findViewById(R.id.btn_b2quiz);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getInCorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        correctAnswers.setText("Correct Answers: " + String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText("Incorrect Answers: " + String.valueOf(getInCorrectAnswers));

        btn_b2quiz.setOnClickListener(view -> finish());
    }
}