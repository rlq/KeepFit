package com.lq.ren.base.ui;

import com.lq.ren.base.ui.reg.RegisterHub;

/**
 * Author lqren on 17/9/14.
 */

public abstract class BaseViewModel {

    private static final String TAG = "core.base.vm";

    private RegisterHub registerHub;

    final public void subscribeToDataStore() {
        registerHub = new RegisterHub();
        subscribeToDataStoreInternal(registerHub);
    }

    protected abstract void subscribeToDataStoreInternal(RegisterHub registerHub);

    public void unsubscribeFromDataStore() {
        if (registerHub != null) {
            registerHub.clear();
            registerHub = null;
        }
    }
}
