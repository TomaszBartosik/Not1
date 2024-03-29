package com.example.not1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    // ==================================
    // MUST BE THE SAME ON BOTH APPS
    // FIXME IMPORTANT: APP team must send to us below variables
    // ==================================
    private static final int NOTIF_ID = 1;
    public static final String NOTIF_TAG = "TAG_YETI";
    private static final String NOTIF_CHANNEL_ID = "notif_channel_id";
    // ==================================

    //public static final String SECOND_APP_ID = "com.example.not2";
    private static final String NOTIF_CHANNEL_NAME = "notif_channel_name_1";
    private static final String NOTIF_CHANNEL_DESCRIPTION = "This is channel 1";
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        createNotificationChanels();


        Notification notification = new Notification.Builder(this, MainActivity.NOTIF_CHANNEL_ID)

                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("aaaa")
                .setContentText("bbbb")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(false)
                .build();
        // TODO: Below line means nothing
        // it works without Delegate
        //notificationManager.setNotificationDelegate(SECOND_APP_ID);

        notificationManager.notify(NOTIF_TAG,
                NOTIF_ID,
                notification);
    }

    private void createNotificationChanels() {
        NotificationChannel channel = new NotificationChannel(
                NOTIF_CHANNEL_ID,
                NOTIF_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
        );
        channel.setDescription(NOTIF_CHANNEL_DESCRIPTION);

        notificationManager.createNotificationChannel(channel);
    }
}
