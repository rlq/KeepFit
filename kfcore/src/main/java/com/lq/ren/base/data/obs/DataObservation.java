package com.lq.ren.base.data.obs;

import android.support.annotation.NonNull;

import com.lq.ren.base.ui.reg.Register;

/**
 * Author lqren on 17/10/11.
 */

public class DataObservation<Data> implements Register {

    private DataObserver<Data> observer;
    private DataObservable<Data> observable;

    public static <Data> DataObservation<Data> create(@NonNull DataObservable<Data> observable,
                                                      @NonNull DataObserver<Data> observer) {
        return new DataObservation<Data>().set(observable, observer);
    }

    private DataObservation<Data> set(@NonNull DataObservable<Data> observable, @NonNull DataObserver<Data> observer) {
        this.observable = observable;
        this.observer = observer;
        this.observable.register(this.observer);
        return this;
    }

    @Override
    public boolean isClear() {
        return false;
    }

    @Override
    public void clear() {
        this.observable.unregister(observer);
        this.observable = null;
        this.observer = null;
    }
}
