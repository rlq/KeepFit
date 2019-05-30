package com.lq.ren.base.data

import android.content.Context
import android.util.Log

import com.lq.ren.base.asset.FitnessType
import com.lq.ren.base.ui.obs.Observable
import com.lq.ren.base.ui.obs.Observation
import com.lq.ren.base.ui.obs.Observer

import java.util.ArrayList

/**
 * Author lqren on 17/10/11.
 */

class DataStorage private constructor(private val context: Context) {

    val exerciseType: List<FitnessType>
        get() {
            val fitnessTypeList = ArrayList<FitnessType>()
            fitnessTypeList.add(FitnessType.OutDoorRunning)
            fitnessTypeList.add(FitnessType.OutDoorWaking)
            fitnessTypeList.add(FitnessType.Riding)
            fitnessTypeList.add(FitnessType.IndoorRunning)
            fitnessTypeList.add(FitnessType.Dumbbell)
            fitnessTypeList.add(FitnessType.Training)
            fitnessTypeList.add(FitnessType.Weighting)
            fitnessTypeList.add(FitnessType.Spinning)
            return fitnessTypeList
        }

    companion object {

        private var sDataStorage: DataStorage? = null

        fun init(context: Context) {
            sDataStorage = DataStorage(context)
        }

        val instance: DataStorage
            get() {
                if (sDataStorage == null) {
                    throw RuntimeException("Call DataStorage.init() before using it")
                }
                return sDataStorage
            }
    }

}
