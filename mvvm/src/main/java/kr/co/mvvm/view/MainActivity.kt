package kr.co.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.mvvm.R
import kr.co.mvvm.databinding.ActivityMainBinding
import kr.co.mvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tv1.text = "aaaa"

//        dataBindingWithViewModel()
//        test1()

        binding.btn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = userViewModel

        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userViewModel.updateText(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

//        lifecycleScope.launch {
//            repeat(1000){
//                val s= binding.etName.text.toString()
//                userViewModel.updateText(s)
//                delay(100)
//            }
//        }

    }



//    private fun dataBindingWithViewModel(){
//        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
//        binding.viewModel = userViewModel
//        userViewModel.increament()
//        binding.lifecycleOwner = this
//        Log.i("main", userViewModel.count.toString())
//    }
//
//    private fun test1(){
//
//        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
//
//        binding.tvName.text = userViewModel.user.value?.name
//        binding.tvAge.text = userViewModel.user.value?.age.toString()
//
//        binding.btnName.setOnClickListener{ userViewModel.updateUserName(binding.etName.text.toString()) }
//        binding.btnAge.setOnClickListener{ userViewModel.updateUserAge(binding.etAge.text.toString()) }
//
//        userViewModel.userAge.observe(this) {
//            lifecycleScope.launch{
//                repeat(1000){
//                    userViewModel.updateUserAge(binding.etAge.text.toString())
//                    delay(1000)
//                }
//
//            }
//
//        }
//
//        userViewModel.user.observe(this) { user ->
//            binding.tvName.text = user.name
//            binding.tvAge.text = user.age.toString()
//        }
//    }

    override fun onStop() {
        super.onStop()
        userViewModel.viewModelScope.cancel()
    }
}