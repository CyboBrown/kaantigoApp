package com.cansev.kaantigo_learncebuano.navigation;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification_Class extends Application {
    public static final String channel1_id = "My First Channel";
    public static final String channel2_id = "My Second Channel";


    @Override
    public void onCreate() {
        super.onCreate();

        // invoke createNotificationChannel method
        createNotificationChannel();

    }

    // define method for creating the notification channels
    private void createNotificationChannel() {
        // check the android version is Oreo or API 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // create Notification Channel object for the first Channel
            NotificationChannel my_channel1 = new NotificationChannel(channel1_id,"My First Channel", NotificationManager.IMPORTANCE_HIGH);

            // customize my_channel1
            my_channel1.setDescription("This is my first channel");

            // create Notification Channel object for the second Channel
            NotificationChannel my_channel2 = new NotificationChannel(channel2_id,"My Second Channel", NotificationManager.IMPORTANCE_DEFAULT);

            // customize my_channel2
            my_channel2.setDescription("This is my second channel");

            // set a reference to the Notification Manager and create the 2 channels
            NotificationManager notifmanager = getSystemService(NotificationManager.class);
            notifmanager.createNotificationChannel(my_channel1);
            notifmanager.createNotificationChannel(my_channel2);

            // register this class in the Manifest file
        }
    }
}
