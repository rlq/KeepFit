package com.lq.ren.base.data

import java.util.ArrayList

/**
 * Author lqren on 17/10/11.
 */

class Summary {

    var userId: String? = null

    //Daily
    var healthTarget = -1
    var steps: Int = 0
    var distance: Float = 0.toFloat()
    var calorie: Float = 0.toFloat()
    var targetProgressRate: Int = 0

    //fit
    val todayExercises: List<Point> = ArrayList()

}
