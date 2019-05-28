package com.lq.he.jet.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lq.he.jet.ui.main.MainFragment

class MainActivity: BaseActivity() {

    override fun getFragment(): Fragment {
        return MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}