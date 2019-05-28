package com.lq.he.jet

import android.text.TextUtils
import android.util.ArrayMap
import android.util.Log

/**
 * 练习Kotlin语法
 */
class Utils {


    fun test() {

        var key = "hahh"
        //（( (status = ? or msgkey = ?) and msgId = ? ) and contactor = ? )
        val queryBuilder = StringBuilder()
        queryBuilder.append("(").append("MSGID").append(" = ?")
        if (!TextUtils.isEmpty(key)) {
            queryBuilder.append(" OR ").append("MSGKEY").append(" = ?)")
        } else {
        }
        queryBuilder.append(" AND ").append("STATUS").append(" = ?")
        queryBuilder.insert(0, if (!TextUtils.isEmpty(key)) "((" else "(").append(") AND ").append("CONTACTER").append(" = ?)")
        Log.e("HEHE", "get string :$queryBuilder")

        var map = ArrayMap<String, Boolean>()
        for (i in 0..3) {
            map["String$i"] = true
        }

        Log.e("HEHE", "String1.value : " + map["String1"])
    }


    /**
     * 语法：
     * 1. 参数格式 a: Int
     * 2. 表达式作为函数体，推断返回值
     * 3. 可变长参数 vararg v: Int
     * 4. lambda
     * 5. 常量,相当于final val a = 1，变量 var a = 1
     * 6. 字符串 var s = "a is $a"
     * 7. null检查机制
     * 8. 基本数据类型，都是封装后的类型，== 比较大小，=== 比较地址
     * 9. 类型自检is ，自动类型转化
     * 10. 区间 i in 1..10 step 2 , i in 1 until 10 [1,10)
     *
     */
    // 2018.08.14 写一些接口，锻炼下
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    public fun sum() = 1 + 2 // 直接作为函数体

    // 可变长参数
    fun vars(vararg v: Int) {
        for (vt in v) {
            // lamdba
            val sumLambda: (Int) -> Int = {vt -> vt + 1}
            print(sumLambda(vt))
        }
    }

    // 5，6，7，8
    fun modle() {
        var a = 1
        // 常量
        val s1 = "a is $a"

        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"

        /** null 检查 */
        var age: String? = "20"

        // throw null exception
        var ages = age!!.toInt()

        // 不做处理，返回null
        ages = age?.toInt()

        // age为空，返回-1
        ages = age?.toInt() ?: -1
    }

    // 9 较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // 类型自动转换
            return obj.length
        }
        return -1
    }


    // 条件，循环语句 if when for while do..while
    fun control() {
        // 作为表达式, 可以使用区间判断
        val max = if (1 in 0..2) 1 else 0

    }


}