package com.lq.ren.base.data.obs

import androidx.annotation.CallSuper

import java.util.ArrayList

/**
 * Author lqren on 17/10/11.
 */

class DataObservable<Data> {

    private val observers = ArrayList<DataObserver<Data>>()

    @CallSuper
    protected fun next(data: Data) {
        for (observer in observers) {
            observer.onNext(this, data)
        }
    }

    @CallSuper
    protected fun error(throwable: Throwable) {
        for (observer in observers) {
            observer.onError(this, throwable)
        }
    }

    @CallSuper
    fun register(observer: DataObserver<Data>) {
        observers.add(observer)
    }

    @CallSuper
    fun unregister(observer: DataObserver<Data>) {
        observers.remove(observer)
    }

}
