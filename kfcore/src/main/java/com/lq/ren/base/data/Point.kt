package com.lq.ren.base.data

import com.lq.ren.base.asset.FitnessDataType
import com.lq.ren.base.asset.FitnessType

/**
 * Author lqren on 17/10/11.
 */

class Point {

    var fitId: String? = null
    var type: FitnessType? = null
    var targetDataType: FitnessDataType? = null
    var targetValue: Float = 0.toFloat()
    var targetRate: Float = 0.toFloat()

    var beginTime: Long = 0
    var endTime: Long = 0
    var duration: Long = 0
    var distance: Float = 0.toFloat()
    var calorie: Float = 0.toFloat()
    var steps: Int = 0
}
