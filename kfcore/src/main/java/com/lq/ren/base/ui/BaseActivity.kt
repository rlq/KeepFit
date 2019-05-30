package com.lq.ren.base.ui

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.util.Log

/**
 * Author lqren on 17/9/14.
 *
 * provide common bar
 */

open class BaseActivity : AppCompatActivity() {

    fun appToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, javaClass.getSimpleName() + ": onCreate " +
                if (savedInstanceState == null) "" else " with $savedInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, javaClass.getSimpleName() + ": onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, javaClass.getSimpleName() + ": onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, javaClass.getSimpleName() + ": onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, javaClass.getSimpleName() + ": onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, javaClass.getSimpleName() + ": onPause")
    }

    companion object {

        private val TAG = "kf.act.base"
    }
}
