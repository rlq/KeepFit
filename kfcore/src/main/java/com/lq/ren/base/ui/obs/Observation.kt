package com.lq.ren.base.ui.obs

import com.lq.ren.base.ui.reg.Register

/**
 * Author lqren on 17/9/14.
 */

class Observation<T> : Register {

    private var observable: Observable<T>? = null
    private var observer: Observer<T>? = null


    override val isClear: Boolean
        get() = false

    private operator fun set(observable: Observable<T>, observer: Observer<T>): Observation<T> {
        this.observable = observable
        this.observer = observer
        this.observable!!.addObserver(this.observer)
        return this
    }

    override fun clear() {
        this.observable!!.deleteObservers()
        this.observable = null
        this.observer = null
    }

    companion object {

        fun <T> create(observable: Observable<T>, observer: Observer<T>): Observation<T> {
            return Observation<T>().set(observable, observer)
        }
    }
}
