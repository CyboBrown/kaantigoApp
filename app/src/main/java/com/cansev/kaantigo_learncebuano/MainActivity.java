package com.cansev.kaantigo_learncebuano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    LessonTabFragment lessonTabFragment = new LessonTabFragment();
    ToolsTabFragment toolsTabFragment = new ToolsTabFragment();
    SearchTabFragment searchTabFragment = new SearchTabFragment();
    QuizTabFragment quizFragment = new QuizTabFragment();
    ProfileTabFragment profileFragment = new ProfileTabFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreCreateDB.copyDB(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_1);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, lessonTabFragment).commit();
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.page_4);
        badgeDrawable.setNumber(69);

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
}