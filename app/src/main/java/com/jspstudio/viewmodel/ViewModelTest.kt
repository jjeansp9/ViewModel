package com.jspstudio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelTest : ViewModel() {
    private var _count = MutableLiveData<Int>().apply {
        value = 0
    }

    val count: LiveData<Int>
        get() = _count

    fun increment(){
        _count.value = (count.value ?: 0) + 1
    }

}