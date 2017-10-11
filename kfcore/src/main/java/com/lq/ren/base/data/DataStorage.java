package com.lq.ren.base.data;

import android.content.Context;
import android.util.Log;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.base.ui.obs.Observable;
import com.lq.ren.base.ui.obs.Observation;
import com.lq.ren.base.ui.obs.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/10/11.
 */

public class DataStorage {

    private static DataStorage sDataStorage;
    private Context context;

    private DataStorage(Context context) {
        this.context = context;
    }

    public static void init(Context context) {
        sDataStorage = new DataStorage(context);
    }

    public static DataStorage getInstance() {
        if (sDataStorage == null) {
            throw new RuntimeException("Call DataStorage.init() before using it");
        }
        return sDataStorage;
    }

    public List<FitnessType> getExerciseType() {
        List<FitnessType> fitnessTypeList = new ArrayList<>();
        fitnessTypeList.add(FitnessType.OutDoorRunning);
        fitnessTypeList.add(FitnessType.OutDoorWaking);
        fitnessTypeList.add(FitnessType.Riding);
        fitnessTypeList.add(FitnessType.IndoorRunning);
        fitnessTypeList.add(FitnessType.Dumbbell);
        fitnessTypeList.add(FitnessType.Training);
        fitnessTypeList.add(FitnessType.Weighting);
        fitnessTypeList.add(FitnessType.Spinning);
        return fitnessTypeList;
    }

}
