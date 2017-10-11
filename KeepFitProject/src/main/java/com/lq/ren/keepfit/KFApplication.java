package com.lq.ren.keepfit;

import android.app.Application;

import com.lq.ren.base.data.DataStorage;

/**
 * Author lqren on 17/9/14.
 */

public class KFApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataStorage.init(this);
    }
}
