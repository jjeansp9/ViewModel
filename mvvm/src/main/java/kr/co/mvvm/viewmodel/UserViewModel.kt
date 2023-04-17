package kr.co.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.mvvm.model.User

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user : LiveData<User>
    get() = _user

    init {
        _user.value = User("Alice", 20)
    }
}
