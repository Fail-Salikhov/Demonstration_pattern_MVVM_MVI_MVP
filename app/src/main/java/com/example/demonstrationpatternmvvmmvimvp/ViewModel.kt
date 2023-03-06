package com.example.demonstrationpatternmvvmmvimvp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {

    private val data = Data()

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun counterVM () {
        data.counter()
        _liveData.value = data.count.toString()
    }
}