package com.cansev.kaantigo_learncebuano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.cansev.kaantigo_learncebuano.navigation.LessonTabFragment;
import com.cansev.kaantigo_learncebuano.navigation.ProfileTabFragment;
import com.cansev.kaantigo_learncebuano.navigation.QuizTabFragment;
import com.cansev.kaantigo_learncebuano.navigation.SearchTabFragment;
import com.cansev.kaantigo_learncebuano.navigation.ToolsTabFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    LessonTabFragment lessonTabFragment = new LessonTabFragment();
    ToolsTabFragment toolsTabFragment = new ToolsTabFragment();
    SearchTabFragment searchTabFragment = new SearchTabFragment();
    QuizTabFragment quizFragment = new QuizTabFragment();
    ProfileTabFragment profileFragment = new ProfileTabFragment();

    private String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        // Find the BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the background color based on the selected theme
        setThemeBackground();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_1);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, lessonTabFragment).commit();
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.page_4);
        badgeDrawable.setNumber(1);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.page_1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, lessonTabFragment).commit();
                    System.out.println("Home");
                    return true;
                case R.id.page_2:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, toolsTabFragment).commit();
                    System.out.println("Tools");
                    return true;
                case R.id.page_3:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, searchTabFragment).commit();
                    System.out.println("Search");
                    return true;
                case R.id.page_4:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, quizFragment).commit();
                    System.out.println("Quiz");
                    return true;
                case R.id.page_5:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                    System.out.println("Profile");
                    return true;
            }
            return false;
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        // Retrieve the saved theme value from SharedPreferences again, in case it has changed
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        selectedTheme = prefs.getString("selected_theme", "default");

        // Update the background color based on the selected theme
        setThemeBackground();
    }

    private void setThemeBackground() {

        switch(selectedTheme) {
            case "theme1":
                bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.lightBlack));
                break;
            case "theme3":
                bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.lightGreenLight));
                break;
            case "theme4":
                bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.lightBlueLight));
                break;
            default:
                bottomNavigationView.setBackgroundColor(Color.parseColor("#6200EE"));
        }

    }
}