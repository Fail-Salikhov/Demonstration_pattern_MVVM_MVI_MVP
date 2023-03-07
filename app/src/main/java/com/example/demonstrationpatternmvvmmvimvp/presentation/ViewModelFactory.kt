package com.example.demonstrationpatternmvvmmvimvp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demonstrationpatternmvvmmvimvp.data.Data

class ViewModelFactory: ViewModelProvider.Factory {

    private val data = Data()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActivityViewModel(data) as T
    }
}