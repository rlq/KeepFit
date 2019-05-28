package com.lq.he.mvvm.ui.task

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.lq.he.mvvm.R
import androidx.navigation.Navigation

class TaskFragment : Fragment() {

    companion object {
        fun newInstance() = TaskFragment()
    }

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.task_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 创建ViewModel，已经包含有Liftcycle的接口 Owner，Observer
        // 从ViewModelProviders获取ViewModel，把本类作为LifecycleOwner.
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        // TODO: Use the ViewModel
        // 在ViewModel中观察Data，作为一个LiveData暴露出去
        viewModel.liveData.observe(this, Observer { data ->
            // Set the text exposed by the LiveData
            view?.findViewById<TextView>(R.id.message)?.text = data
        })

        // 设置点击事件
        view?.findViewById<Button>(R.id.navigate_bt)?.setOnClickListener {
            // Navigate to the login destination
            view?.let { Navigation.findNavController(it).navigate(R.id.end_action) }
        }
    }

}
