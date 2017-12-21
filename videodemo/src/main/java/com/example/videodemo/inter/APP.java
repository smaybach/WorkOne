package com.example.videodemo.inter;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lenovo on 2017/12/20.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
