package com.example.demonstrationpatternmvvmmvimvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demonstrationpatternmvvmmvimvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val data = Data()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            data.counter()
            binding.textView.text = data.count.toString()
        }


    }
}