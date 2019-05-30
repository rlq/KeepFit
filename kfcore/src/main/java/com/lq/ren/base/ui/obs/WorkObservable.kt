package com.lq.ren.base.ui.obs

/**
 * An observable that return the last value when add an observer.
 */
class WorkObservable<T> : Observable<T>() {

    private var lastValue: T? = null
    private var hasLastValue = false

    override fun notifyObservers() {
        var hasLast: Boolean
        var last: T?
        synchronized(this) {
            hasLast = hasLastValue
            last = lastValue
        }
        if (hasLast) {
            setChanged()
            super.notifyObserver(last)
        }
    }

    override fun notifyObserver(data: T?) {
        synchronized(this) {
            hasLastValue = true
            lastValue = data
        }
        setChanged()
        super.notifyObserver(data)
    }

    override fun addObserver(observer: Observer<T>?) {
        super.addObserver(observer)

        // Just update given observer, not affect other observers.
        if (observer != null) {
            var hasLast: Boolean
            var last: T?
            synchronized(this) {
                hasLast = hasLastValue
                last = lastValue
            }
            if (hasLast) {
                observer.update(this, last)
            }
        }
    }
}
