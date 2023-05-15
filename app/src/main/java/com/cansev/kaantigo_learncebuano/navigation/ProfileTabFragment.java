package com.cansev.kaantigo_learncebuano.navigation;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cansev.kaantigo_learncebuano.MainActivity;
import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileTabFragment extends Fragment {
    AlertDialog.Builder builder;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileTabFragment newInstance(String param1, String param2) {
        ProfileTabFragment fragment = new ProfileTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button btn1, btn2, btn5;
    MaterialButton edit;
    TextView name;
    Switch notificationSwitch;
    private String selectedTheme;

    boolean isNotificationScheduled;
    SharedPreferences prefs;

    SharedPreferences.Editor editor;

    String savedUsername;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Get an instance of SharedPreferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");


        // Retrieve the saved username from SharedPreferences
        savedUsername = prefs.getString("username", "Default Username");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);

        applyTheme(view);

        edit = view.findViewById(R.id.edit);
        name = view.findViewById(R.id.name);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn5 = view.findViewById(R.id.btn5);
        notificationSwitch = view.findViewById(R.id.notificationSwitch);

        name.setText(savedUsername);


        // Load the notification flag from SharedPreferences
        isNotificationScheduled = prefs.getBoolean("is_notification_scheduled", false);

        // Initialize the notification switch
        notificationSwitch.setChecked(isNotificationScheduled);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Edit Username");

// Set up the input
                final EditText input = new EditText(getContext());
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the new username from the EditText
                        String newUsername = input.getText().toString();

                        // Save the new username
                        editor = prefs.edit();
                        editor.putString("username", newUsername);
                        editor.apply();

                        name.setText(newUsername);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), Themes.class);
                startActivity(intent1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), AchievementsActivity.class);
                startActivity(intent2);
            }
        });

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Save the notification flag to SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("is_notification_scheduled", isChecked);
                editor.apply();
                //if(!isNotificationScheduled) {
                if (isChecked) {
                    // The switch is on
                    // Show time picker dialog
                    final Calendar calendar = Calendar.getInstance();
                    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    final int minute = calendar.get(Calendar.MINUTE);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    // Schedule the notification at the selected time
                                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                    calendar.set(Calendar.MINUTE, minute);
                                    calendar.set(Calendar.SECOND, 0);
                                    scheduleNotification(calendar.getTimeInMillis());

                                    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                                    String formattedTime = dateFormat.format(calendar.getTime());
                                    Toast.makeText(getContext(), "Notification scheduled for " + formattedTime, Toast.LENGTH_SHORT).show();
                                }
                            }, hour, minute, android.text.format.DateFormat.is24HourFormat(getContext()));
                    timePickerDialog.show();
                    //}
                } else {
                    // The switch is off
                    // Cancel the scheduled notification
                    cancelNotification();
                    // Show toast message
                    Toast.makeText(getContext(), "Notification canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the progress using SharedPreferences
                SharedPreferences.Editor editor = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();

                // Reset Lesson Completion AchievementsActivity:
                editor.putBoolean("isLessonCaseMarkersCompleted", false);
                editor.putBoolean("isLessonPersonalPronounsCompleted", false);
                editor.putBoolean("isLessonDemonstrativePronounsCompleted", false);

                // Reset Quiz Completion AchievementsActivity:
                editor.putBoolean("isQuizCaseMarkersCompleted", false);
                editor.putBoolean("isQuizPersonalPronounsCompleted", false);
                editor.putBoolean("isQuizDemonstrativePronounsCompleted", false);

                // Reset Perfect Score AchievementsActivity:
                editor.putBoolean("isQuizCaseMarkersPerfect", false);
                editor.putBoolean("isQuizPersonalPronounsPerfect", false);
                editor.putBoolean("isQuizDemonstrativePronounsPerfect", false);
                editor.apply();
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Apply the selected theme
        applyTheme(getView());
    }

    @Override
    public void onPause() {
        super.onPause();
        // Save the notification flag to SharedPreferences
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("is_notification_scheduled", notificationSwitch.isChecked());
        editor.apply();
    }

    private void scheduleNotification(long delay) {
        Intent resultIntent = new Intent(getContext(), MainActivity.class);
        Intent notificationIntent = new Intent(getContext(), MyNotificationReceiver.class);
        notificationIntent.putExtra("resultIntent", resultIntent);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

        // Calculate the time difference between now and the selected time
        long currentTime = System.currentTimeMillis();
        long timeDifference = delay - currentTime;

        // Schedule the notification with the time difference as the delay parameter
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, currentTime + timeDifference, pendingIntent);
    }


    private void cancelNotification() {
        Intent notificationIntent = new Intent(getContext(), MyNotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

    private void applyTheme(View view) {
        TextView profile = view.findViewById(R.id.profile);
        TextView name = view.findViewById(R.id.name);
        TextView preferences = view.findViewById(R.id.preferences);
        Button themes = view.findViewById(R.id.btn1);
        Button viewAchievements = view.findViewById(R.id.btn2);
        Switch notifications = view.findViewById(R.id.notificationSwitch);
        Button language = view.findViewById(R.id.btn4);
        Button resetProgress = view.findViewById(R.id.btn5);
        MaterialCardView profile_card = view.findViewById(R.id.card_quiz);
        MaterialButton edit = view.findViewById(R.id.edit);
        View divider = view.findViewById(R.id.divider);
        ImageView profile_back = view.findViewById(R.id.profile_back);

        switch(selectedTheme) {
            case "theme1":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                profile.setTextColor(Color.WHITE);
                name.setTextColor(Color.WHITE);
                preferences.setTextColor(Color.WHITE);
                themes.setTextColor(Color.WHITE);
                viewAchievements.setTextColor(Color.WHITE);
                notifications.setTextColor(Color.WHITE);
                language.setTextColor(Color.WHITE);
                resetProgress.setTextColor(Color.WHITE);
                profile_card.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                edit.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                break;
            case "theme3":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                profile.setTextColor(Color.WHITE);
                name.setTextColor(Color.WHITE);
                preferences.setTextColor(Color.WHITE);
                themes.setTextColor(Color.WHITE);
                viewAchievements.setTextColor(Color.WHITE);
                notifications.setTextColor(Color.WHITE);
                language.setTextColor(Color.WHITE);
                resetProgress.setTextColor(Color.WHITE);
                profile_card.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                edit.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                break;
            case "theme4":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                profile.setTextColor(Color.WHITE);
                name.setTextColor(Color.WHITE);
                preferences.setTextColor(Color.WHITE);
                themes.setTextColor(Color.WHITE);
                viewAchievements.setTextColor(Color.WHITE);
                notifications.setTextColor(Color.WHITE);
                language.setTextColor(Color.WHITE);
                resetProgress.setTextColor(Color.WHITE);
                profile_card.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                edit.setTextColor(Color.WHITE);
                profile_back.setColorFilter(Color.WHITE);
                break;
        }
    }
}