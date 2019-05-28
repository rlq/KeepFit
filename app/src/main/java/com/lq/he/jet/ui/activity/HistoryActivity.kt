package com.lq.he.jet.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lq.he.jet.ui.history.HistoryFragment

class HistoryActivity: BaseActivity() {

    override fun getFragment(): Fragment {
        return HistoryFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}