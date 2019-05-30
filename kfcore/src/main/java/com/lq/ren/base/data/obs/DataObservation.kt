package com.lq.ren.base.data.obs

import com.lq.ren.base.ui.reg.Register

/**
 * Author lqren on 17/10/11.
 */

class DataObservation<Data> : Register {

    private var observer: DataObserver<Data>? = null
    private var observable: DataObservable<Data>? = null

    override val isClear: Boolean
        get() = false

    private operator fun set(observable: DataObservable<Data>, observer: DataObserver<Data>): DataObservation<Data> {
        this.observable = observable
        this.observer = observer
        this.observable!!.register(this.observer)
        return this
    }

    override fun clear() {
        this.observable!!.unregister(observer)
        this.observable = null
        this.observer = null
    }

    companion object {

        fun <Data> create(observable: DataObservable<Data>,
                          observer: DataObserver<Data>): DataObservation<Data> {
            return DataObservation<Data>().set(observable, observer)
        }
    }
}
