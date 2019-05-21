package com.example.fit;

import android.location.Location;
import android.support.v4.app.NotificationCompat;

public class Visitor {

    public static void checkNotification(CustomNotification customNotification, Location location, int notification_id, NotificationCompat.Builder builder) {
        if(customNotification.checkCondition(location) == true ) {
            customNotification.execute(notification_id, builder);
        }
    }
}
