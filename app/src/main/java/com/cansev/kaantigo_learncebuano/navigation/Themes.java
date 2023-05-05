package com.cansev.kaantigo_learncebuano.navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;

public class Themes extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        btn1 = findViewById(R.id.theme1);
        btn2 = findViewById(R.id.theme2);

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

//                Intent intent = new Intent(Themes.this, MainActivity.class);
//                startActivity(intent);
//                Intent intent1 = getIntent();
//                finish();
//                startActivity(intent1);
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

//                Intent intent1 = getIntent();
//                finish();
//                startActivity(intent1);

                // Navigate back to LessonTabFragment


//                Intent intent = new Intent(Themes.this, MainActivity.class);
//                startActivity(intent);
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
            }
        });
    }

}