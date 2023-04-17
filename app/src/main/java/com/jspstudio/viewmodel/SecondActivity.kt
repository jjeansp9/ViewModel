package com.jspstudio.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.jspstudio.viewmodel.databinding.ActivitySecondBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

        viewModel.count.observe(this) { count ->
            binding.tv.text = "Count : $count"
            Log.i("Second","$count")
        }



    }

}