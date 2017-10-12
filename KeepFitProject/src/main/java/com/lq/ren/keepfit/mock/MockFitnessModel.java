package com.lq.ren.keepfit.mock;

import com.lq.ren.base.asset.FitnessDataType;
import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.base.data.Point;
import com.lq.ren.base.data.Summary;
import com.lq.ren.base.ui.reg.RegisterHub;
import com.lq.ren.keepfit.model.FitnessModel;

import java.util.Calendar;
import java.util.Date;

/**
 * Author lqren on 17/10/11.
 */

public class MockFitnessModel extends FitnessModel {

    @Override
    protected void subscribeToDataStoreInternal(RegisterHub registerHub) {
        super.subscribeToDataStoreInternal(registerHub);
        getSummaryChange().notifyObserver(getSummary());
    }

    private Summary getSummary() {
        Summary summary = new Summary();
        summary.userId = "";
        summary.healthTarget = 20000;
        summary.steps = 12000;
        summary.targetProgressRate = summary.steps / summary.healthTarget;
        summary.calorie = 400;
        summary.distance = 2000;

        summary.todayExercises.add(getPoint(1));
        summary.todayExercises.add(getPoint(2));
        summary.todayExercises.add(getPoint(3));
        return summary;
    }

    private Point getPoint(int i) {
        Point point = new Point();
        point.type = FitnessType.Dumbbell;
        point.beginTime = getDate(0, -(i)).getTime();
        point.endTime = getDate(0, -(i - 1)).getTime();
        point.calorie = 100 + i * 20;
        point.distance = 1000 + i * 20;
        point.targetDataType = FitnessDataType.Distance;
        point.fitId = "" + i;
        point.steps = 2000;
        return point;
    }

    private Date getDate(int d, int h) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, d);
        calendar.add(Calendar.HOUR, h);
        return new Date(calendar.getTimeInMillis());
    }
}
