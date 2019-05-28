package com.lq.ren.base.data.obs;

import androidx.annotation.CallSuper;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/10/11.
 */

public class DataObservable<Data> {

    private final List<DataObserver<Data>> observers = new ArrayList<>();

    @CallSuper
    protected void next(Data data) {
        for (DataObserver<Data> observer : observers) {
            observer.onNext(this, data);
        }
    }

    @CallSuper
    protected void error(Throwable throwable) {
        for (DataObserver<Data> observer : observers) {
            observer.onError(this, throwable);
        }
    }

    @CallSuper
    public void register(DataObserver<Data> observer) {
        observers.add(observer);
    }

    @CallSuper
    public void unregister(DataObserver<Data> observer) {
        observers.remove(observer);
    }

}
