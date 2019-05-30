package com.lq.ren.base.session

import com.lq.ren.base.data.BaseData
import com.lq.ren.base.data.obs.DataObservable
import com.lq.ren.base.data.obs.DataObserver

/**
 * Author lqren on 17/10/11.
 * Data产生后转为UI使用的数据
 */

class FitnessDataTracker : DataObserver<BaseData> {


    override fun onNext(observable: DataObservable<BaseData>, baseData: BaseData) {

    }

    override fun onError(observable: DataObservable<BaseData>, throwable: Throwable) {

    }
}
