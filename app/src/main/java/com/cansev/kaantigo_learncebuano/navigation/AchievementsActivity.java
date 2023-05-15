package com.cansev.kaantigo_learncebuano.navigation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;

public class AchievementsActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

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
}
