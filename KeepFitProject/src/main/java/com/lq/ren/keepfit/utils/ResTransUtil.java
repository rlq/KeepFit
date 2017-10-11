package com.lq.ren.keepfit.utils;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.keepfit.R;

/**
 * Author lqren on 17/10/11.
 */

public class ResTransUtil {

    public static String mapFitnessType(FitnessType type) {
        switch (type) {
            case OutDoorRunning:
                return "OutDoorRunning";
            case OutDoorWaking:
                return "OutDoorWaking";
            case Riding:
                return "Riding";
            case IndoorRunning:
                return "IndoorRunning";
            case Dumbbell:
                return "Dumbbell";
            case Training:
                return "Training";
            case Spinning:
                return "Spinning";
            case Weighting:
                return "Weighting";
            default:
                throw new RuntimeException("Fitness type is none");
        }
    }

    public static int mapFitnessTypeImage(FitnessType type) {
        switch (type) {
            case OutDoorRunning:
                return R.drawable.bg_run;
            case OutDoorWaking:
                return R.drawable.bg_walk;
            case Riding:
                return R.drawable.bg_bicycle;
            case IndoorRunning:
                return R.drawable.bg_run;
            case Dumbbell:
                return R.drawable.bg_dumbbell;
            case Training:
                return R.drawable.bg_train;
            case Spinning:
                return R.drawable.bg_spinning;
            case Weighting:
                return R.drawable.bg_weight;
            default:
                throw new RuntimeException("Fitness type is none");
        }
    }

}
