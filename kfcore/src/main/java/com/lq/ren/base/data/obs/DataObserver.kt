package com.lq.ren.base.data.obs

/**
 * Author lqren on 17/10/11.
 */

interface DataObserver<Data> {

    fun onNext(observable: DataObservable<Data>, data: Data)

    fun onError(observable: DataObservable<Data>, throwable: Throwable)
}
