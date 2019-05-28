package com.lq.he.recycle

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ViewAnimator
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var logShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                    replace(R.id.sample_content_fragment, RecyclerFragment())
                        .commit()
                }
        }
    }

    /* 先去掉LogFragment
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        // menu 可为空，menu? 判空
        menu?.findItem(R.id.menu_toggle_log)?.run {
            isVisible = findViewById<ViewAnimator>(R.id.sample_output) is ViewAnimator
            setTitle(if (logShown) R.string.sample_hide_log else R.string.sample_show_log)
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.expanded_menu -> {
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    */
}
