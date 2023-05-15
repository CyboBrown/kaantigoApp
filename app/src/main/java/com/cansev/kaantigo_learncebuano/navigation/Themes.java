package com.cansev.kaantigo_learncebuano.navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;

public class Themes extends AppCompatActivity {

    ImageView themes_back;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        themes_back = findViewById(R.id.themes_back);
        btn1 = findViewById(R.id.theme1);
        btn2 = findViewById(R.id.theme2);
        btn3 = findViewById(R.id.theme3);
        btn4 = findViewById(R.id.theme4);

        themes_back.setOnClickListener(view -> finish());

        btn1.setOnClickListener(view -> {
            // Save selected theme in SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            prefs.edit().putString("selected_theme", "theme1").apply();

            // Restart the app to apply the new theme
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btn2.setOnClickListener(view -> {
            // Save selected theme in SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            prefs.edit().putString("selected_theme", "theme2").apply();

            // Restart the app to apply the new theme
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btn3.setOnClickListener(view -> {
            // Save selected theme in SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            prefs.edit().putString("selected_theme", "theme3").apply();

            // Restart the app to apply the new theme
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btn4.setOnClickListener(view -> {
            // Save selected theme in SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            prefs.edit().putString("selected_theme", "theme4").apply();

            // Restart the app to apply the new theme
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

}