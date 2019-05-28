@file:JvmName("Converter")

package com.lq.he.mvvm.utils

import kotlin.math.round


/** 时间格式化 */
fun fromTenthsToSeconds(tenths: Int) : String {
    return if (tenths < 600) {
        String.format("%.1f", tenths / 10.0)
    } else {
        val minutes = (tenths / 10) / 60
        val seconds = (tenths / 10) % 60
        String.format("%d:%2d", minutes, seconds)
    }
}

/* 将 3 : 10 :20 转换为 秒 , 首先使用正则分割时，分，秒，*/
fun cleanSecondsString(seconds: String) : Int {
    val filteredValue = seconds.replace(Regex("""[^\d:.]]"""), "")
    if (filteredValue.isEmpty()) return 0

    val elements: List<Int> = filteredValue.split(":").map {
        it -> round(it.toDouble()).toInt()
    }

    var result: Int
    return when {
        // 如果分割的数组 > 2
        elements.size > 2 -> 0
        elements.size > 1 -> {
            result = elements[0] * 60
            result += elements[1]
            result * 10
        }
        else -> elements[0] * 10
    }
}

