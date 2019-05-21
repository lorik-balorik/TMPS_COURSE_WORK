package com.example.fit;

import android.content.Context;

import io.paperdb.Paper;

public final class Singleton {

    private static volatile Singleton instance;

    private Singleton() { }

    public static Singleton getInstance(Context thisContext) {

        Paper.init(thisContext);

        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton();
                }
            }
        }
        return instance;
    }

}