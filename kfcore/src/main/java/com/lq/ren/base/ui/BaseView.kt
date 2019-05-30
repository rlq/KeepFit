package com.lq.ren.base.ui

/**
 * Author lqren on 17/9/14.
 */

interface BaseView<T : BaseViewModel> {

    fun setViewModel(viewModel: T)
}
