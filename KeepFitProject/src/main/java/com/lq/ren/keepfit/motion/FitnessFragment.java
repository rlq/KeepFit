package com.lq.ren.keepfit.motion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lq.ren.base.asset.FitnessType;
import com.lq.ren.base.data.Summary;
import com.lq.ren.base.ui.BaseFragment;
import com.lq.ren.base.ui.BaseView;
import com.lq.ren.base.ui.BaseViewModel;
import com.lq.ren.base.ui.obs.Observable;
import com.lq.ren.base.ui.obs.Observation;
import com.lq.ren.base.ui.obs.Observer;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.mock.MockFitnessModel;
import com.lq.ren.keepfit.model.FitnessModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author lqren on 17/10/9.
 */

public class FitnessFragment extends BaseFragment implements BaseView<FitnessModel> {

    private static final String TAG = "motion.working.frag";

    @BindView(R.id.type_view)
    RecyclerView typeRecyclerView;

    @BindView(R.id.health_today)
    TodayHealthView todayhealthView;

    private FitnessTypeAdapter typeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fit, container, false);
    }

    @NonNull
    @Override
    protected BaseViewModel createViewModel() {
        return new MockFitnessModel();
    }

    @NonNull
    @Override
    protected BaseView createView() {
        return this;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        initTypeView();
    }

    private void initTypeView() {
        typeAdapter = new FitnessTypeAdapter(getContext());
        typeRecyclerView.setAdapter(typeAdapter);
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        typeAdapter.setClickTypeListener(new FitnessTypeAdapter.FitnessTypeClickListener() {
            @Override
            public void onClickType(FitnessType type) {

            }
        });
    }

    @Override
    public void setViewModel(FitnessModel viewModel) {
        if (viewModel == null) {
            return;
        }
        Observation.create(viewModel.getTypeChange(), new Observer<List<FitnessType>>() {
            @Override
            public void update(Observable<List<FitnessType>> observer, List<FitnessType> data) {
                typeAdapter.setTypeData(data);
            }

        });

        Observation.create(viewModel.getSummaryChange(), new Observer<Summary>() {
            @Override
            public void update(Observable<Summary> observer, Summary data) {
                todayhealthView.setHealthView(data);
            }
        });
    }
}
