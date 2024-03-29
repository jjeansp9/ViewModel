package com.jspstudio.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelTest : ViewModel() {

    private var _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init {
        _count.value = 0
    }

    fun increment() {
        viewModelScope.launch(Dispatchers.Main) {
            repeat(100) {
                _count.value = _count.value?.plus(1)
                Log.i("count", _count.value.toString())
                delay(1000)
            }
        }
    }
}