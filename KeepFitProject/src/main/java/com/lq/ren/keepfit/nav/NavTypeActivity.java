package com.lq.ren.keepfit.nav;

import android.os.Bundle;
import androidx.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.lq.ren.base.ui.BaseActivity;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.utils.UIActive;

/**
 * Author lqren on 17/9/14.
 */

public class NavTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nav);

        if (savedInstanceState == null) {
            NavType type = (NavType) getIntent().getExtras().getSerializable(UIActive.NAV_TYPE);
            if (type == null) {
                finish();
            }
            Fragment fragment = mapNavFragment(type);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .commitAllowingStateLoss();
        }
    }

    @NonNull
    private Fragment mapNavFragment(NavType type) {
        switch (type) {
            case Profile:
                return new ProfileFragment();
            case History:
                return new HistoryFragment();
            case Favor:
            case Shopping:
                return new ProfileFragment();
            case Settings:
                return new SettingsFragment();
            case Help:
            case AboutApp:
                return new AboutAppFragment();
            default:
                return new ProfileFragment();
        }
    }
}
