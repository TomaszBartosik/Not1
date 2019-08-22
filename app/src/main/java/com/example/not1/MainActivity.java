package com.example.not1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_1_ID = "channel1";
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChanels();


        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        Notification notification = new Notification.Builder(this, MainActivity.CHANNEL_1_ID)

                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("aaaa")
                .setContentText("bbbb")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .build();
        notificationManager.setNotificationDelegate("com.example.not2");
        notificationManager.notify(1,notification);



        //Toast.makeText(getApplicationContext(),"FIRST SERVICE",Toast.LENGTH_SHORT).show();


    }


    private void createNotificationChanels(){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 1");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
    }
}
