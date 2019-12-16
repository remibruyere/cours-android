package com.bruyere.tpreceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import java.util.Random;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyReceiver extends BroadcastReceiver {

    public static final String TP_RECEIVER = "TPReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getAction();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder notifBuilder;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notifBuilder = new NotificationCompat.Builder(context);
        } else {
            NotificationChannel channel = new NotificationChannel(TP_RECEIVER, TP_RECEIVER, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = context.getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
            notifBuilder = new NotificationCompat.Builder(context, TP_RECEIVER);
        }

        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = notifBuilder.setContentTitle(message)
                .setContentText(context.getString(R.string.app_name))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .addAction(new NotificationCompat.Action(R.mipmap.ic_launcher_round, "Test", pendingIntent))
                .build();

        NotificationManagerCompat nmc = NotificationManagerCompat.from(context);
        nmc.notify(new Random().nextInt(), notification);
    }
}
