package com.jspstudio.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jspstudio.viewmodel.databinding.ActivityMainBinding
import com.jspstudio.viewmodel.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding : ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    private lateinit var viewModel : ViewModelTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ViewModelTest::class.java]
        binding.btn.setOnClickListener{
            viewModel.increment()
        }

        val countObserver = Observer<Int>{ count ->
            binding.tv.text = "Count : ${count}"
        }

        viewModel.count.observe(this, countObserver)




    }
}