package com.cansev.kaantigo_learncebuano.navigation;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.cansev.kaantigo_learncebuano.MainActivity;
import com.cansev.kaantigo_learncebuano.R;

public class MyNotificationReceiver extends BroadcastReceiver {
    private NotificationManagerCompat notifcompat;
    @Override
    public void onReceive(Context context, Intent intent) {
        notifcompat = NotificationManagerCompat.from(context);
        // get the notification title and content from the intent extras
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        // The switch is on
        //                String title = "Title";
//                String message = "This is a message"

        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);

        Notification notif = new NotificationCompat.Builder(context, Notification_Class.channel1_id)
                .setContentTitle("Kaantigo - Learn Cebuano")
                .setContentText("Success starts with small steps. Take one now and study.")
                .setSmallIcon(R.drawable.profile_icon)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build();


        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notifcompat.notify(1, notif);
    }
}
