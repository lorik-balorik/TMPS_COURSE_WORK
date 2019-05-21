package com.example.fit;

import android.location.Location;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class LocationNotification implements CustomNotification {
    @Override
    public boolean checkCondition(Location location) {

        if( time == Calendar.getInstance().getTime().toString() && location.toString() == place){
            return true;
        }
        return false;
    }

    @Override
    public void execute(int notificationId, NotificationCompat.Builder builder) {

    }
}
