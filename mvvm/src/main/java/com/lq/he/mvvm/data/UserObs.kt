package com.lq.he.mvvm.data

import androidx.databinding.ObservableField

class UserObs {

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val age = ObservableField<Int>()
}