package com.jspstudio.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList : MutableLiveData<List<User>> = _userList

    fun loadUsers(){
        val users = listOf(
            User(1, "Alice"),
            User(2, "Bob"),
            User(3, "Charlie")
        )
        _userList.value = users
    }
}