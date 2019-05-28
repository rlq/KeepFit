package com.lq.ren.base.data.obs;

import androidx.annotation.NonNull;

/**
 * Author lqren on 17/10/11.
 */

public interface DataObserver<Data> {

    void onNext(DataObservable<Data> observable, @NonNull Data data);

    void onError(DataObservable<Data> observable, Throwable throwable);
}
