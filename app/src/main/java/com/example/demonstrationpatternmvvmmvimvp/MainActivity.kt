package com.example.demonstrationpatternmvvmmvimvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.demonstrationpatternmvvmmvimvp.databinding.ActivityMainBinding
import com.example.demonstrationpatternmvvmmvimvp.presentation.ActivityViewModel
import com.example.demonstrationpatternmvvmmvimvp.presentation.ColorEvent
import com.example.demonstrationpatternmvvmmvimvp.presentation.CountEvent
import com.example.demonstrationpatternmvvmmvimvp.presentation.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private lateinit var vm: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this, ViewModelFactory())[ActivityViewModel::class.java]

        binding.buttonNumber.setOnClickListener {
            vm.send(CountEvent())
        }

        vm.liveData.observe(this){
            binding.textView.text = it.number.toString()
            binding.textView.setTextColor(it.color)
        }

        binding.buttonColor.setOnClickListener {
            vm.send(ColorEvent())
        }

    }
}