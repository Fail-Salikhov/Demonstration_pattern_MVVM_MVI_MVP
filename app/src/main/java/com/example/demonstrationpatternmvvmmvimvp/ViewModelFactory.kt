package com.example.demonstrationpatternmvvmmvimvp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory: ViewModelProvider.Factory {

    private val data = Data()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActivityViewModel(data) as T
    }
}