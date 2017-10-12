package com.lq.ren.keepfit.motion;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lq.ren.base.data.Point;
import com.lq.ren.base.data.Summary;
import com.lq.ren.base.utils.UnitUtils;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.utils.ResTransUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author lqren on 17/10/9.
 */

public class TodayHealthView extends RelativeLayout {

    private static final int MIN_STEPS = 5000;
    private static final int MAX_STEPS = 95000;

    @BindView(R.id.progressBar)
    ProgressBar targetProgress;
    @BindView(R.id.target_des)
    TextView targetDes;

    @BindView(R.id.target_value)
    TextView targetValue;
    @BindView(R.id.distance)
    TextView distanceText;
    @BindView(R.id.calorie)
    TextView calorieText;

    @BindView(R.id.target_setting)
    View targetSettingView;
    @BindView(R.id.target_picker)
    NumberPicker targetPicker;
    @BindView(R.id.target_confirm)
    Button targetConfirm;

    @BindView(R.id.sport_today)
    RecyclerView todayFitRecycler;

    private TodayHealthAdapter adapter;
    private Summary summary;

    public TodayHealthView(Context context) {
        super(context);
        init();
    }

    public TodayHealthView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TodayHealthView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_today, this, true);
        ButterKnife.bind(this);
        adapter = new TodayHealthAdapter();
        todayFitRecycler.setAdapter(adapter);
        todayFitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        setTargetProgress();
    }

    private void setTargetProgress() {
        final String[] stepArray = new String[((MAX_STEPS - MIN_STEPS) / 5000) + 1];
        for (int i = MIN_STEPS / 5000; i <= MAX_STEPS / 5000; i++) {
            stepArray[i - MIN_STEPS / 5000] = (i * 5000 + MIN_STEPS) + "";
        }
        targetPicker.setDisplayedValues(stepArray);
        targetPicker.setMaxValue((MAX_STEPS - MIN_STEPS) / 5000);
        targetPicker.setMinValue(0);

        targetDes.setText(getContext().getString(R.string.target_des,
                summary != null && summary.healthTarget != 0 ? summary.healthTarget : stepArray[0]));

        targetDes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                targetSettingView.setVisibility(VISIBLE);
            }
        });
        targetConfirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                targetDes.setText(getContext().getString(R.string.target_des, stepArray[targetPicker.getValue()]));
                if (summary != null) {
                    targetProgress.setProgress(summary.targetProgressRate);
                }
                targetSettingView.setVisibility(INVISIBLE);
            }
        });
    }

    public void setHealthView(Summary summary) {
        this.summary = summary;
        targetProgress.setProgress(summary.targetProgressRate);
        targetValue.setText(summary.steps + "步");

        distanceText.setText(String.format(Locale.US, "%.0f", UnitUtils.Distance.m2km(summary.distance)) + " km");
        calorieText.setText(String.format(Locale.US, "%.0f", summary.calorie) + " kcal");

        adapter.setTodayFit(summary.todayExercises);
    }

    class TodayHealthAdapter extends RecyclerView.Adapter<TodayHealthViewHolder> {

        private final List<Point> todayFitLists = new ArrayList<>();

        void setTodayFit(List<Point> points) {
            todayFitLists.clear();
            todayFitLists.addAll(points);
            notifyDataSetChanged();
        }

        @Override
        public TodayHealthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.view_fit_item, parent, false);
            final TodayHealthViewHolder holder = new TodayHealthViewHolder(view);
            holder.root.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO open the fit Id detail info
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(TodayHealthViewHolder holder, int position) {
            holder.onBindViewHolder(todayFitLists, position);
        }

        @Override
        public int getItemCount() {
            return todayFitLists.size();
        }
    }


    class TodayHealthViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView exerciseTime;
        private TextView typeName;
        private TextView targetRate;

        public TodayHealthViewHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.fit_item);
            exerciseTime = itemView.findViewById(R.id.exercise_time);
            typeName = itemView.findViewById(R.id.type_name);
            targetRate = itemView.findViewById(R.id.target_rate);
        }

        void onBindViewHolder(List<Point> todayFitLists, int position) {
            root.setTag(todayFitLists.get(position).fitId);
            exerciseTime.setText("" + todayFitLists.get(position).duration);
            typeName.setText(ResTransUtil.mapFitnessType(todayFitLists.get(position).type));
            targetRate.setText(String.format(Locale.US, "%.0f%%", todayFitLists.get(position).targetRate));
        }
    }

}
