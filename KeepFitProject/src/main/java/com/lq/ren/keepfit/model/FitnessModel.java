package com.lq.ren.keepfit.model;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.base.data.DataStorage;
import com.lq.ren.base.data.Summary;
import com.lq.ren.base.ui.BaseViewModel;
import com.lq.ren.base.ui.obs.WorkObservable;
import com.lq.ren.base.ui.obs.Observable;
import com.lq.ren.base.ui.reg.RegisterHub;

import java.util.List;

/**
 * Author lqren on 17/10/10.
 * fitness type data
 * Daily health data and today exercise datas
 */

public class FitnessModel extends BaseViewModel {

    private static final String TAG = "model.work";

    private final WorkObservable<List<FitnessType>> typeObservable = new WorkObservable<>();

    private final WorkObservable<Summary> summaryObservable = new WorkObservable<>();

    public Observable<List<FitnessType>> getTypeChange() {
        return typeObservable;
    }

    public Observable<Summary> getSummaryChange() {
        return summaryObservable;
    }

    @Override
    protected void subscribeToDataStoreInternal(RegisterHub registerHub) {
        typeObservable.notifyObserver(DataStorage.getInstance().getExerciseType());
    }
}
