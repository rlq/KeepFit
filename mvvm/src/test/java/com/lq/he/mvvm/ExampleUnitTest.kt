package com.lq.he.mvvm

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.round

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /* 将3.10.100 转为3 : 10 :20 计算 秒 , 首先使用正则分割时，分，秒，*/
    @Test
    fun cleanSecondsString() {
        val seconds = "3:10:20"
//        val seconds = "10.20"
        val filteredValue = seconds.replace(Regex("""[^\d:.]]"""), ",")
        System.out.print("filteredValue :" + filteredValue + "\n")
        if (filteredValue.isEmpty()) return

        val elements: List<Int> = filteredValue.split(":").map {
                it -> round(it.toDouble()).toInt()
        }
        System.out.print("elements size :" + elements.size + "\n")

        var result: Int
        when {
            // 如果分割的数组 > 2 有小时则秒就清掉, >1 没有小时则把分钟计算秒 , 其他
            elements.size > 2 -> {
                System.out.print("elements>2  0 :" + elements[0] + ", 1 :" + elements[1] +
                        ", 2 :"+ elements[2] + "\n")
            }
            elements.size > 1 -> {
                result = elements[0] * 60
                result += elements[1]
                result * 10
                System.out.print("elements>1 0 :" + elements[0] + ", 1 :" + elements[1] + ", result :" + result +  "\n")
            }
            else -> {
                System.out.print("elements其他 0 :" + elements[0] + "\n")
                elements[0] * 10
            }

        }
    }
}
