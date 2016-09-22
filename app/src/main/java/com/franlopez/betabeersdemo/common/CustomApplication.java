package com.franlopez.betabeersdemo.common;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
