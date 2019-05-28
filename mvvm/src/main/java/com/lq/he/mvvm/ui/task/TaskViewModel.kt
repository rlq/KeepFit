package com.lq.he.mvvm.ui.task

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.*

/**
 * 1. 在别的APP中 extendds AndroidViewModel,需要传入Application
 * 2. 找到2个工程，使用MVVM模式，然后自己做一个APP出来
 * 3. 使用到的技术点：以架构图为例，ViewModel, LiveData，Lifecycle, Room, Net Lib
 * 4. 使用Databinding 将ViewModel绑定xml
 *    findViewById<TextView>(R.id.text).apply{text = viewModel.userName}
 *    XML <TextView android:text="@{viewmodel.userName}" />
 *
 */
//class TaskViewModel(application: Application) : AndroidViewModel(application) {
class TaskViewModel: ViewModel(), Observable {

    private val data = MutableLiveData<String>()
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    val liveData: LiveData<String>
        get() = data

    init {
        data.value = "Hello Jetpack!"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        callbacks.remove(callback)
    }
}
