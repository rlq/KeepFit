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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lq.he.mvvm.R
import com.lq.he.mvvm.data.ProfileObservableViewModel
import com.lq.he.mvvm.databinding.VmProfileBinding

/**
 * This activity uses a [android.arch.lifecycle.ViewModel] to hold the data and respond to user
 * actions. Also, the layout uses [android.databinding.BindingAdapter]s instead of expressions
 * which are much more powerful.
 *
 * @see com.example.android.databinding.basicsample.util.BindingAdapters
 */
class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtain ViewModel from ViewModelProviders
        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        // Obtain binding
        val binding: VmProfileBinding =
                DataBindingUtil.setContentView(this, R.layout.vm_profile)

        // Bind layout with ViewModel
//        binding. = viewModel
    }
}
