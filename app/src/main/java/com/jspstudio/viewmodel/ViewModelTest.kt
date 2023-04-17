package com.jspstudio.viewmodel

import androidx.lifecycle.ViewModel

class ViewModelTest : ViewModel() {
    private var _count = 0

    val count: Int
        get() = _count

    fun increment(){
        _count++
    }

}