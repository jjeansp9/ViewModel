package kr.co.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.mvvm.model.User
import java.math.BigInteger

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    init {
        _user.value = User("Alice", 200)
    }

    fun updateUserName(name: String){
        val newUser = user.value?.copy(name = name)
        _user.value = newUser!!
    }

    fun updateUserAge(age : Long){
        val newUser = user.value?.copy(age = age)
        _user.value = newUser!!
    }

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init {
        _count.value = 0
    }

    fun increament(){
        viewModelScope.launch {
            while (true){
                _count.value = count.value?.plus(1)

                delay(1)

                if (_count.value == 10000){
                    break
                }
            }
        }

    }
}
























