package com.zc.shop.base;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";

    static Context _context;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }

}
