package com.example.fit;

import android.app.Notification;
import android.app.NotificationManager;
import android.location.Location;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class TimeNotification implements CustomNotification {

    @Override
    public boolean checkCondition(Location location) {

        if( time == Calendar.getInstance().getTime().toString()){
            return true;
        }
        return false;
    }

    @Override
    public void execute(int notificationId, NotificationCompat.Builder builder) {
            notificationManager.notify(notificationId, builder.build());
    }
}
