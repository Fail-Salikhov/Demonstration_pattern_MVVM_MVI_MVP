package com.example.demonstrationpatternmvvmmvimvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.demonstrationpatternmvvmmvimvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private lateinit var vm: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[ActivityViewModel::class.java]

        binding.buttonNumber.setOnClickListener {
            vm.buttonIncrease()
        }

        vm.numberLiveData.observe(this){
            binding.textView.text = it
        }

        binding.buttonColor.setOnClickListener {
            vm.buttonChangeColor()
        }

        vm.colorLiveData.observe(this){
            binding.textView.setTextColor(it)
        }
    }
}