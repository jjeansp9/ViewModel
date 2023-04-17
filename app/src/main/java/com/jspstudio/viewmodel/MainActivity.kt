package com.jspstudio.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.jspstudio.viewmodel.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

        testViewModel()

        binding.btn.setOnClickListener{startActivity(Intent(this, SecondActivity::class.java))}
    }



    private fun testViewModel(){
        viewModelTest = ViewModelProvider(this)[ViewModelTest::class.java]
        viewModelTest.increment()
        viewModelTest.count.observe(this) { count ->
            Log.i("MainActivity","$count")
        }
    }
}