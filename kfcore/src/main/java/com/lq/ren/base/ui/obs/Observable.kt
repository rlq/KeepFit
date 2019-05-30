package com.lq.ren.base.ui.obs

import java.util.ArrayList

open class Observable<T> {

    internal var observers: MutableList<Observer<T>> = ArrayList()

    internal var changed = false

    open fun addObserver(observer: Observer<T>?) {
        if (observer == null) {
            throw NullPointerException("observer == null")
        }
        synchronized(this) {
            if (!observers.contains(observer))
                observers.add(observer)
        }
    }

    protected fun clearChanged() {
        changed = false
    }

    @Synchronized
    fun deleteObserver(observer: Observer<T>) {
        observers.remove(observer)
    }

    @Synchronized
    fun deleteObservers() {
        observers.clear()
    }

    fun hasChanged(): Boolean {
        return changed
    }

    protected fun setChanged() {
        changed = true
    }

    open fun notifyObservers() {
        notifyObserver(null)
    }

    open fun notifyObserver(data: T?) {
        var size = 0
        var arrays: Array<Observer<T>>? = null
        synchronized(this) {
            if (hasChanged()) {
                clearChanged()
                size = observers.size
                arrays = arrayOfNulls<Observer<*>>(size)
                observers.toTypedArray<Observer<T>>()
            }
        }
        if (arrays != null) {
            for (observer in arrays!!) {
                observer.update(this, data)
            }
        }
    }

}
