package kr.co.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.mvvm.R
import kr.co.mvvm.databinding.ActivityMainBinding
import kr.co.mvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        dataBindingWithViewModel()

        test1()

    }

    private fun dataBindingWithViewModel(){
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.viewModel = userViewModel
        userViewModel.increament()
        binding.lifecycleOwner = this
    }

    private fun test1(){

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.tvName.text = userViewModel.user.value?.name
        binding.tvAge.text = userViewModel.user.value?.age.toString()

        binding.btnName.setOnClickListener{ userViewModel.updateUserName(binding.etName.text.toString()) }
        binding.btnAge.setOnClickListener{ userViewModel.updateUserAge(binding.etAge.text.toString().toLong()) }

        userViewModel.user.observe(this) { user ->
            binding.tvName.text = user.name
            binding.tvAge.text = user.age.toString()
        }

    }
}