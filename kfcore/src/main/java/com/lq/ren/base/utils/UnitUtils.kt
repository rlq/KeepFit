package com.lq.ren.base.utils

/**
 * Author lqren on 17/10/12.
 */

class UnitUtils {

    object Time {
        fun ms2min(ms: Long): Float {
            return ms.toFloat() / 1000f / 60f
        }

        fun s2h(s: Float): Float {
            return s / 60f / 60f
        }
    }

    object Distance {
        fun m2km(m: Float): Float {
            return m / 1000f
        }
    }
}
