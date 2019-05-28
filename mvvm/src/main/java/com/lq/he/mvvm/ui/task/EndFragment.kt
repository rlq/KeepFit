package com.lq.he.mvvm.ui.task

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.lq.he.mvvm.R
import com.lq.he.mvvm.data.User
import com.lq.he.mvvm.data.UserObs
import com.lq.he.mvvm.databinding.FragmentEndBinding
import com.lq.he.mvvm.ui.task.TaskFragment

/**
 * package 竟然可以不和路径相同
 * xml 使用 androidx 下的组件
 */
class EndFragment : Fragment() {

    private lateinit var viewModel: EndViewModel
    private lateinit var endBinding: FragmentEndBinding

        companion object {
        fun newInstance() = TaskFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        endBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_end, container, false)
        return endBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /** 使用userObservable */
//        val userObs: UserObs = UserObs()


        /** 使用data user */
        endBinding.user = User("haha", "17")

        // Obtain ViewModel from ViewModelProviders, using this fragment as LifecycleOwner.
        viewModel = ViewModelProviders.of(this).get(EndViewModel::class.java)

        // Observe data on the ViewModel, exposed as a LiveData
        viewModel.data.observe(this, Observer { data ->
            // Set the text exposed by the LiveData
            view?.findViewById<TextView>(R.id.text)?.text = data
        })
    }
}