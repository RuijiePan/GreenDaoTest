package com.ruijie.greendaotest;

import android.app.Application;

import com.ruijie.greendaotest.manager.DBManager;

/**
 * Created by panruijie on 2018/6/20.
 */
public class DBApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.initSingleton(this);
    }
}
