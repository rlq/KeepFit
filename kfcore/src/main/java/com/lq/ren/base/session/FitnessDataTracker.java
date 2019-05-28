package com.lq.ren.base.session;

import androidx.annotation.NonNull;

import com.lq.ren.base.data.BaseData;
import com.lq.ren.base.data.obs.DataObservable;
import com.lq.ren.base.data.obs.DataObserver;

/**
 * Author lqren on 17/10/11.
 * Data产生后转为UI使用的数据
 */

public class FitnessDataTracker implements DataObserver<BaseData> {


    @Override
    public void onNext(DataObservable<BaseData> observable, @NonNull BaseData baseData) {

    }

    @Override
    public void onError(DataObservable<BaseData> observable, Throwable throwable) {

    }
}
