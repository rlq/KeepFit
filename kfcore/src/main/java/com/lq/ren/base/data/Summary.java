package com.lq.ren.base.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/10/11.
 */

public class Summary {

    public String userId;

    //Daily
    public int healthTarget = -1;
    public int steps;
    public float distance;
    public float calorie;
    public int targetProgressRate;

    //fit
    public final List<Point> todayExercises = new ArrayList<>();

}
