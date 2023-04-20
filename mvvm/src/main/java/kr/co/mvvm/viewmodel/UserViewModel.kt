package kr.co.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.mvvm.model.User
import java.math.BigInteger

class UserViewModel : ViewModel() {
//    private val _user = MutableLiveData<User>()
//    val user: LiveData<User>
//        get() = _user
//
//    private val _userAge = MutableLiveData<String>()
//    val userAge: LiveData<String>
//        get() = _userAge
//
//    init {
//        _user.value = User("Alice", 200)
//    }
//
//    fun updateUserName(name: String){
//        val newUser = user.value?.copy(name = name)
//        _user.value = newUser!!
//    }
//
//
//
//    fun updateUserAge(age : String){
//        viewModelScope.launch {
//            repeat(1000){
//                _userAge.value = age
//
//                delay(1000)
//            }
//
//        }
//
//    }
//
//    private val _count = MutableLiveData<Int>()
//    val count: LiveData<Int> = _count
//
//    init {
//        _count.value = 0
//    }
//
//    fun increament(){
//        viewModelScope.launch {
//            repeat(1000){
//                _count.value = count.value?.plus(1)
//
//                delay(1000)
//                Log.i("viewmodel", _count.value.toString())
//            }
//        }
//    }

    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    fun updateText(newText: String) {
        _text.value = newText
    }
}
























