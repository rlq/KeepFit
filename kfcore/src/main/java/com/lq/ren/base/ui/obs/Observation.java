package com.lq.ren.base.ui.obs;

import android.support.annotation.NonNull;

import com.lq.ren.base.ui.reg.Register;

/**
 * Author lqren on 17/9/14.
 */

public class Observation<T> implements Register {

    private Observable<T> observable;
    private Observer<T> observer;

    public static <T> Observation<T> create(@NonNull Observable<T> observable, @NonNull Observer<T> observer) {
        return new Observation<T>().set(observable, observer);
    }

    private Observation<T> set(@NonNull Observable<T> observable, @NonNull Observer<T> observer) {
        this.observable = observable;
        this.observer = observer;
        this.observable.addObserver(this.observer);
        return this;
    }


    @Override
    public boolean isClear() {
        return false;
    }

    @Override
    public void clear() {
        this.observable.deleteObservers();
        this.observable = null;
        this.observer = null;
    }
}
