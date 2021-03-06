package com.lq.ren.base.ui.obs

/**
 * Author lqren on 17/9/14.
 * 观察者被object实现，接收Object的改变通知。使用被观察者通知的数据做更新操作。
 */

interface Observer<T> {

    fun update(observer: Observable<T>, data: T)
}
