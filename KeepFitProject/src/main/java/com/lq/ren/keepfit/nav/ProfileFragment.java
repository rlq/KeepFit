package com.lq.ren.keepfit.nav;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lq.ren.base.ui.BaseFragment;
import com.lq.ren.base.ui.BaseView;
import com.lq.ren.base.ui.BaseViewModel;
import com.lq.ren.keepfit.model.ProfileModel;

/**
 * Author lqren on 17/9/14.
 */

public class ProfileFragment extends BaseFragment implements BaseView<ProfileModel> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    protected BaseViewModel createViewModel() {
        return null;
    }

    @NonNull
    @Override
    protected BaseView createView() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setViewModel(ProfileModel viewModel) {

    }
}

