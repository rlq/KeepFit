package com.lq.he.jet.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lq.he.jet.R

/**
 * 第一次尝试使用Android Jetpack去写APP
 * 每个Activity都沿用这个风格，作为一个BaseActivity
 *  * 如果没有abstract method，就必须将本类设置为open，因为默认是final
 * 把一些base的类都可以拿来用，组织成自己的架构风格
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, getFragment())
                .commitNow()
        }
    }

    // 子类实现，将他们对应的Fragment传进来
    abstract fun getFragment(): Fragment

}
