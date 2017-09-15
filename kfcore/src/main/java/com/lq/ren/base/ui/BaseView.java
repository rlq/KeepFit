package com.lq.ren.base.ui;

/**
 * Author lqren on 17/9/14.
 */

public interface BaseView<T extends BaseViewModel> {

    void setViewModel(T viewModel);
}
