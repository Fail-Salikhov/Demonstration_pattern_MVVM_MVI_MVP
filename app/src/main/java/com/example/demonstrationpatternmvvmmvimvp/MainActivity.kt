package com.example.demonstrationpatternmvvmmvimvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demonstrationpatternmvvmmvimvp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val data = Data()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonNumber.setOnClickListener {
            data.counter()
            binding.textView.text = data.count.toString()
        }

        binding.buttonColor.setOnClickListener {
            setRandomColor()
        }
    }

    private fun setRandomColor() {
        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        binding.textView.setTextColor(randomColor)
    }
}