package com.example.demonstrationpatternmvvmmvimvp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demonstrationpatternmvvmmvimvp.data.Data
import com.example.demonstrationpatternmvvmmvimvp.databinding.ActivityMainBinding
import com.example.demonstrationpatternmvvmmvimvp.prsentation.MainPresenter
import com.example.demonstrationpatternmvvmmvimvp.prsentation.MainPresenterImpl
import com.example.demonstrationpatternmvvmmvimvp.prsentation.MainView


class MainActivity : AppCompatActivity(), MainView {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val presenter: MainPresenter = MainPresenterImpl(Data(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonNumber.setOnClickListener {
            presenter.increaseNumber()
        }

        binding.buttonColor.setOnClickListener {
            presenter.changeColor()
        }
    }

    override fun showResult(number: Int, color: Int) {
        binding.textView.text = number.toString()
        binding.textView.setTextColor(color)
    }
}