package com.shan.xmldemo;

import android.app.Application;

/**
 * Created by root on 17-2-4.
 */

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    /**
     * MyApp初始化操作
     */
    private void init() {
        instance = (MyApp) getApplicationContext();
    }

}
