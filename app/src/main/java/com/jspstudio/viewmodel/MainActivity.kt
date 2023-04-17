package com.jspstudio.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jspstudio.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MyViewModel
    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var viewModelTest : ViewModelTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        viewModel.userList.observe(this, { userList ->
//            // userList를 사용하여 UI 업데이트
//        })
//
//
//        viewModel.loadUsers()

        binding.btn.setOnClickListener{startActivity(Intent(this, SecondActivity::class.java))}


        viewModelTest = ViewModelProvider(this)[ViewModelTest::class.java]

        viewModelTest.count.observe(this) { count ->
            Log.i("MainActivity","$count")
        }

    }
}