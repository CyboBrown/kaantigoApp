package com.cansev.kaantigo_learncebuano.navigation;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

public class AchievementsActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

        ImageView profile_back = findViewById(R.id.profile_back);
        profile_back.setOnClickListener(view -> finish());

        // Get the SharedPreferences instance
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Lesson Completion AchievementsActivity:
        boolean isLessonCaseMarkersCompleted = preferences.getBoolean("isLessonCaseMarkersCompleted", false);
        boolean isLessonPersonalPronounsCompleted = preferences.getBoolean("isLessonPersonalPronounsCompleted", false);
        boolean isLessonDemonstrativePronounsCompleted = preferences.getBoolean("isLessonDemonstrativePronounsCompleted", false);

        // Quiz Completion AchievementsActivity:
        boolean isQuizCaseMarkersCompleted = preferences.getBoolean("isQuizCaseMarkersCompleted", false);
        boolean isQuizPersonalPronounsCompleted = preferences.getBoolean("isQuizPersonalPronounsCompleted", false);
        boolean isQuizDemonstrativePronounsCompleted = preferences.getBoolean("isQuizDemonstrativePronounsCompleted", false);

        // Perfect Score AchievementsActivity:
        boolean isQuizCaseMarkersPerfect = preferences.getBoolean("isQuizCaseMarkersPerfect", false);
        boolean isQuizPersonalPronounsPerfect = preferences.getBoolean("isQuizPersonalPronounsPerfect", false);
        boolean isQuizDemonstrativePronounsPerfect = preferences.getBoolean("isQuizDemonstrativePronounsPerfect", false);


        /*----------------------------------------------Lessons Completed----------------------------------------*/

        // If the case markers lesson is completed, do something
        if (isLessonCaseMarkersCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "case markers" lesson
            ImageView lessonCaseMarkersLocked = findViewById(R.id.lessonCaseMarkersLocked);
            lessonCaseMarkersLocked.setImageResource(R.drawable.achievements_unlocked);
        }

        // If the personal pronouns lesson is completed, do something
        if (isLessonPersonalPronounsCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "personal pronouns" lesson

        }

        // If the demonstrative pronouns lesson is completed, do something
        if (isLessonDemonstrativePronounsCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "demonstrative pronouns" lesson

        }

        /*----------------------------------------------Quizzes Completed----------------------------------------*/

        // If the case markers quiz is completed, do something
        if (isQuizCaseMarkersCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "case markers" quiz
            ImageView quizCaseMarkersLocked = findViewById(R.id.quizCaseMarkersLocked);
            quizCaseMarkersLocked.setImageResource(R.drawable.achievements_unlocked);
        }

        // If the personal pronouns quiz is completed, do something
        if (isQuizPersonalPronounsCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "personal pronouns" quiz

        }

        // If the demonstrative pronouns quiz is completed, do something
        if (isQuizDemonstrativePronounsCompleted) {
            // TODO: Implement the logic to display the achievement for completing the "demonstrative pronouns" quiz

        }

        /*----------------------------------------------Perfect Quizzes----------------------------------------*/

        // If the case markers quiz is perfect, do something
        if (isQuizCaseMarkersPerfect) {
            // TODO: Implement the logic to display the achievement for completing with a perfect score in "case markers" quiz
            ImageView perfectCaseMarkersLocked = findViewById(R.id.perfectCaseMarkersLocked);
            perfectCaseMarkersLocked.setImageResource(R.drawable.achievements_unlocked);
        }

        // If the personal pronouns quiz is perfect, do something
        if (isQuizPersonalPronounsPerfect) {
            // TODO: Implement the logic to display the achievement for completing with a perfect score in "personal pronouns" quiz

        }

        // If the demonstrative pronouns quiz is perfect, do something
        if (isQuizDemonstrativePronounsPerfect) {
            // TODO: Implement the logic to display the achievement for completing with a perfect score in "demonstrative pronouns" quiz

        }

    }

    private void applyTheme() {
        LinearLayout achievementsPage = findViewById(R.id.achievementsPage);
        MaterialCardView card_lesson_completion = findViewById(R.id.card_lesson_completion);
        MaterialCardView card_quiz_completion = findViewById(R.id.card_quiz_completion);
        MaterialCardView card_perfect_score = findViewById(R.id.card_perfect_score);
        TextView lesson = findViewById(R.id.lesson);
        TextView quiz = findViewById(R.id.quiz);
        TextView perfect = findViewById(R.id.perfect);

        TextView caseMarkers1 = findViewById(R.id.caseMarkers1);
        TextView personalPronouns1 = findViewById(R.id.personalPronouns1);
        TextView demonstrativePronouns1 = findViewById(R.id.demonstrativePronouns1);

        TextView caseMarkers2 = findViewById(R.id.caseMarkers2);
        TextView personalPronouns2 = findViewById(R.id.personalPronouns2);
        TextView demonstrativePronouns2 = findViewById(R.id.demonstrativePronouns2);

        TextView caseMarkers3 = findViewById(R.id.caseMarkers3);
        TextView personalPronouns3 = findViewById(R.id.personalPronouns3);
        TextView demonstrativePronouns3 = findViewById(R.id.demonstrativePronouns3);

        ImageView profile_back = findViewById(R.id.profile_back);
        TextView profile = findViewById(R.id.profile);
        View divider = findViewById(R.id.divider);

        switch (selectedTheme) {
            case "theme1":
                achievementsPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                card_lesson_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_quiz_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_perfect_score.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                lesson.setTextColor(Color.WHITE);
                quiz.setTextColor(Color.WHITE);
                perfect.setTextColor(Color.WHITE);

                caseMarkers1.setTextColor(Color.WHITE);
                personalPronouns1.setTextColor(Color.WHITE);
                demonstrativePronouns1.setTextColor(Color.WHITE);

                caseMarkers2.setTextColor(Color.WHITE);
                personalPronouns2.setTextColor(Color.WHITE);
                demonstrativePronouns2.setTextColor(Color.WHITE);

                caseMarkers3.setTextColor(Color.WHITE);
                personalPronouns3.setTextColor(Color.WHITE);
                demonstrativePronouns3.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                profile.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                break;
            case "theme3":
                achievementsPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                card_lesson_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_quiz_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_perfect_score.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                lesson.setTextColor(Color.WHITE);
                quiz.setTextColor(Color.WHITE);
                perfect.setTextColor(Color.WHITE);

                caseMarkers1.setTextColor(Color.WHITE);
                personalPronouns1.setTextColor(Color.WHITE);
                demonstrativePronouns1.setTextColor(Color.WHITE);

                caseMarkers2.setTextColor(Color.WHITE);
                personalPronouns2.setTextColor(Color.WHITE);
                demonstrativePronouns2.setTextColor(Color.WHITE);

                caseMarkers3.setTextColor(Color.WHITE);
                personalPronouns3.setTextColor(Color.WHITE);
                demonstrativePronouns3.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                profile.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                break;
            case "theme4":
                achievementsPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                card_lesson_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_quiz_completion.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_perfect_score.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                lesson.setTextColor(Color.WHITE);
                quiz.setTextColor(Color.WHITE);
                perfect.setTextColor(Color.WHITE);

                caseMarkers1.setTextColor(Color.WHITE);
                personalPronouns1.setTextColor(Color.WHITE);
                demonstrativePronouns1.setTextColor(Color.WHITE);

                caseMarkers2.setTextColor(Color.WHITE);
                personalPronouns2.setTextColor(Color.WHITE);
                demonstrativePronouns2.setTextColor(Color.WHITE);

                caseMarkers3.setTextColor(Color.WHITE);
                personalPronouns3.setTextColor(Color.WHITE);
                demonstrativePronouns3.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                profile.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                break;
        }
    }
}
