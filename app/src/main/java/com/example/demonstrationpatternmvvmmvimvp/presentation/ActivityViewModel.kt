package com.example.demonstrationpatternmvvmmvimvp.presentation

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demonstrationpatternmvvmmvimvp.data.Data
import kotlin.random.Random

class ActivityViewModel(
    private val data: Data
): ViewModel() {


    private val _liveData = MutableLiveData<MainState>()
    val liveData: LiveData<MainState> = _liveData

    private val _colorLiveData = MutableLiveData<Int>(-0x1000000)
    val colorLiveData: LiveData<Int> = _colorLiveData


    fun send(event: MainEvent) {
        when(event) {
            is IncreaseNumberEvent -> {
                increaseNumberVM()
            }
            is ColorChangeEvent -> {
                setRandomColor()
            }
        }
    }

    private fun increaseNumberVM () {
        data.increaseNumber()
        _liveData.value = MainState(data.count, -0x1000000)
    }

    private fun setRandomColor() {
        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        _liveData.value = MainState(data.count, randomColor)
    }
}