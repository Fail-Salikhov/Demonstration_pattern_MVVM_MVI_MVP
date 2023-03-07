package com.example.demonstrationpatternmvvmmvimvp.prsentation

import android.graphics.Color
import com.example.demonstrationpatternmvvmmvimvp.data.Data
import kotlin.random.Random

class MainPresenterImpl(
    private val data: Data,
    private val view: MainView
) : MainPresenter {

    override fun increaseNumber() {
        data.counter()
        view.showResult(data.count, -0x1000000)
    }

    override fun changeColor() {
        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        view.showResult(data.count, randomColor)
    }
}