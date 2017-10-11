package com.lq.ren.base.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Author lqren on 17/9/14.
 */

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "core.base.frag";

    private BaseViewModel viewModel;
    private BaseView baseview;

    @NonNull
    protected abstract BaseViewModel createViewModel();

    @NonNull
    protected abstract BaseView createView();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseview = createView();
        viewModel.subscribeToDataStore();
    }

    @Override
    public void onResume() {
        super.onResume();
        baseview.setViewModel(viewModel);
    }

    @Override
    public void onPause() {
        super.onPause();
        baseview.setViewModel(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.unsubscribeFromDataStore();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel = null;
    }

}
