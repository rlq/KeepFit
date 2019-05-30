package com.lq.ren.base.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Author lqren on 17/9/14.
 */

abstract class BaseFragment : Fragment() {

    private var viewModel: BaseViewModel? = null
    private var baseview: BaseView<*>? = null

    protected abstract fun createViewModel(): BaseViewModel

    protected abstract fun createView(): BaseView<*>


    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    open fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseview = createView()
        viewModel!!.subscribeToDataStore()
    }

    fun onResume() {
        super.onResume()
        baseview!!.setViewModel(viewModel)
    }

    fun onPause() {
        super.onPause()
        baseview!!.setViewModel(null)
    }

    fun onDestroyView() {
        super.onDestroyView()
        viewModel!!.unsubscribeFromDataStore()
    }

    fun onDestroy() {
        super.onDestroy()
        viewModel = null
    }

    companion object {

        private val TAG = "core.base.frag"
    }

}
