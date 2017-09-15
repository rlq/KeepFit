package com.lq.ren.keepfit.utils;

import android.content.Context;
import android.content.Intent;

import com.lq.ren.keepfit.nav.NavType;
import com.lq.ren.keepfit.nav.NavTypeActivity;

/**
 * Author lqren on 17/9/14.
 */

public class UIActive {

    public static final String NAV_TYPE = "nav_type";

    public static void openNavTypeActivity(Context context, NavType type) {
        Intent intent = new Intent(context, NavTypeActivity.class);
        intent.putExtra(NAV_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
