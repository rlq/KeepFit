package com.lq.ren.base.ui

import com.lq.ren.base.ui.reg.RegisterHub

/**
 * Author lqren on 17/9/14.
 */

abstract class BaseViewModel {

    private var registerHub: RegisterHub? = null

    fun subscribeToDataStore() {
        registerHub = RegisterHub()
        subscribeToDataStoreInternal(registerHub)
    }

    protected abstract fun subscribeToDataStoreInternal(registerHub: RegisterHub)

    fun unsubscribeFromDataStore() {
        if (registerHub != null) {
            registerHub!!.clear()
            registerHub = null
        }
    }

    companion object {

        private val TAG = "core.base.vm"
    }
}
