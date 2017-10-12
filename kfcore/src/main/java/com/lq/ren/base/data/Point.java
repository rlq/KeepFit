package com.lq.ren.base.data;

import com.lq.ren.base.asset.FitnessDataType;
import com.lq.ren.base.asset.FitnessType;

/**
 * Author lqren on 17/10/11.
 */

public class Point {

    public String fitId;
    public FitnessType type;
    public FitnessDataType targetDataType;
    public float targetValue;
    public float targetRate;

    public long beginTime;
    public long endTime;
    public long duration;
    public float distance;
    public float calorie;
    public int steps;
}
