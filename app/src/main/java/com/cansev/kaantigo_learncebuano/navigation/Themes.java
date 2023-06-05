package com.cansev.kaantigo_learncebuano.navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

public class Themes extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4;
    private String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);


        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

        btn1 = findViewById(R.id.theme1);
        btn2 = findViewById(R.id.theme2);
        btn3 = findViewById(R.id.theme3);
        btn4 = findViewById(R.id.theme4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save selected theme in SharedPreferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("selected_theme", "theme1").apply();

                // Restart the app to apply the new theme
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save selected theme in SharedPreferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("selected_theme", "theme2").apply();

                // Restart the app to apply the new theme
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save selected theme in SharedPreferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("selected_theme", "theme3").apply();

                // Restart the app to apply the new theme
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save selected theme in SharedPreferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("selected_theme", "theme4").apply();

                // Restart the app to apply the new theme
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void applyTheme() {
        ImageView themes_back = findViewById(R.id.themes_back);
        TextView themes = findViewById(R.id.themes);
        LinearLayout themesPage= findViewById(R.id.themesPage);
        View divider = findViewById(R.id.divider);

        switch (selectedTheme) {
            case "theme1":
                themes_back.setColorFilter(Color.WHITE);
                //ContextCompat.getColor(getContext(), R.color.lightBlueLight)
                themes.setTextColor(Color.WHITE);
                themesPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                break;
            case "theme3":
                themes_back.setColorFilter(Color.WHITE);
                //ContextCompat.getColor(getContext(), R.color.lightBlueLight)
                themes.setTextColor(Color.WHITE);
                themesPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                break;
            case "theme4":
                themes_back.setColorFilter(Color.WHITE);
                //ContextCompat.getColor(getContext(), R.color.lightBlueLight)
                themes.setTextColor(Color.WHITE);
                themesPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                break;
        }
    }
}