package com.lq.ren.base.utils;

/**
 * Author lqren on 17/10/12.
 */

public class UnitUtils {

    public static class Time {
        public static float ms2min(long ms) {
            return ms / 1000f / 60f;
        }

        public static float s2h(float s) {
            return s / 60f / 60f;
        }
    }

    public static class Distance {
        public static float m2km(float m) {
            return m / 1000f;
        }
    }
}
