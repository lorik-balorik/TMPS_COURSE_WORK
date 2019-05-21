package com.example.fit;

import android.app.Notification;
import android.app.NotificationManager;
import android.location.Location;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public interface CustomNotification {
    String time = new String();
    String place = new String();
    Notification notification = null;
    NotificationManager notificationManager = null;

    boolean checkCondition(Location location);
    void execute(int notificationId, NotificationCompat.Builder builder);
}

