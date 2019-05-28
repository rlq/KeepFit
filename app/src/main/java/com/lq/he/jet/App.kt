package com.lq.he.jet

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Android Jetpack地址
 * doc  https://developer.android.com/jetpack/docs/getting-started
 * code https://github.com/googlesamples/android-sunflower
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}