/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lq.he.mvvm.ui.task

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModelProviders
import com.lq.he.mvvm.R
import com.lq.he.mvvm.data.IntervalTimerViewModel
import com.lq.he.mvvm.data.IntervalTimerViewModelFactory
import com.lq.he.mvvm.databinding.ActivityMainBinding
import com.lq.he.mvvm.databinding.IntervalTimerBinding

/**
 * Shows a menu.
 */
class MainActivity : AppCompatActivity() {

    private val intervalTimerViewModel: IntervalTimerViewModel
            by lazy {
                ViewModelProviders.of(this, IntervalTimerViewModelFactory)
                    .get(IntervalTimerViewModel::class.java)
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The layout for this activity is a Data Binding layout so it needs to be inflated using
        // DataBindingUtil.
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)

        binding.textView.setText("haha")
        binding.observableactivityActivityLabel.setText("hahah")
        // The returned binding has references to all the Views with an ID.
        binding.observableFieldsActivityButton.setOnClickListener {
            startActivity(Intent(this, ObservableFieldActivity::class.java))
        }
        binding.viewmodelActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }

        val timerBinding: IntervalTimerBinding = DataBindingUtil.setContentView(
            this, R.layout.interval_timer)
        val viewmodel = intervalTimerViewModel
        timerBinding.viewmodel = viewmodel

        /* Save the user settings whenever they change */
        observeAndSaveTimePerSet(
            viewmodel.timePerWorkSet, R.string.prefs_timePerWorkSet)
        observeAndSaveTimePerSet(
            viewmodel.timePerRestSet, R.string.prefs_timePerRestSet)

        /* Number of sets needs a different  */
        observeAndSaveNumberOfSets(viewmodel)

        if (savedInstanceState == null) {
            /* If this is the first run, restore shared settings */
            restorePreferences(viewmodel)
            observeAndSaveNumberOfSets(viewmodel)
        }
    }

    private fun observeAndSaveTimePerSet(timePerWorkSet: ObservableInt, prefsKey: Int) {
        timePerWorkSet.addOnPropertyChangedCallback(
            object : Observable.OnPropertyChangedCallback() {
                @SuppressLint("CommitPrefEdits")
                override fun onPropertyChanged(observable: Observable?, p1: Int) {
                    Log.d("saveTimePerWorkSet", "Saving time-per-set preference")
                    val sharedPref =
                        getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
                    sharedPref.edit().apply {
                        putInt(getString(prefsKey), (observable as ObservableInt).get())
                        commit()
                    }
                }
            })
    }

    private fun restorePreferences(viewModel: IntervalTimerViewModel) {
        val sharedPref =
            getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
        val timePerWorkSetKey = getString(R.string.prefs_timePerWorkSet)
        var wasAnythingRestored = false
        if (sharedPref.contains(timePerWorkSetKey)) {
            viewModel.timePerWorkSet.set(sharedPref.getInt(timePerWorkSetKey, 100))
            wasAnythingRestored = true
        }
        val timePerRestSetKey = getString(R.string.prefs_timePerRestSet)
        if (sharedPref.contains(timePerRestSetKey)) {
            viewModel.timePerRestSet.set(sharedPref.getInt(timePerRestSetKey, 50))
            wasAnythingRestored = true
        }
        val numberOfSetsKey = getString(R.string.prefs_numberOfSets)
        if (sharedPref.contains(numberOfSetsKey)) {
            viewModel.numberOfSets = arrayOf(0, sharedPref.getInt(numberOfSetsKey, 5))
            wasAnythingRestored = true
        }
        if (wasAnythingRestored) Log.d("saveTimePerWorkSet", "Preferences restored")
        viewModel.stopButtonClicked()
    }

    private fun observeAndSaveNumberOfSets(viewModel: IntervalTimerViewModel) {
        viewModel.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            @SuppressLint("CommitPrefEdits")
            override fun onPropertyChanged(observable: Observable?, p1: Int) {
                if (p1 == BR.numberOfSets) {
                    Log.d("saveTimePerWorkSet", "Saving number of sets preference")
                    val sharedPref =
                        getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
                    sharedPref.edit().apply {
                        putInt(getString(R.string.prefs_numberOfSets), viewModel.numberOfSets[1])
                        commit()
                    }
                }
            }
        })
    }
}
