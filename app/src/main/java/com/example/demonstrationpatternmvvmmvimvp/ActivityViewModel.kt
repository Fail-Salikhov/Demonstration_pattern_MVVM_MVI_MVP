package com.example.demonstrationpatternmvvmmvimvp

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ActivityViewModel(): ViewModel() {

    private val data = Data()

    private val _numberLiveData = MutableLiveData<String>()
    val numberLiveData: LiveData<String> = _numberLiveData

    private val _colorLiveData = MutableLiveData<Int>(-0x1000000)
    val colorLiveData: LiveData<Int> = _colorLiveData

    fun buttonIncrease () {
        data.increaseNumber()
        _numberLiveData.value = data.count.toString()
    }

    fun buttonChangeColor() {
        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        _colorLiveData.value = randomColor
    }
}