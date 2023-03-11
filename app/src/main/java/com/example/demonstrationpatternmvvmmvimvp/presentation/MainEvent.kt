package com.example.demonstrationpatternmvvmmvimvp.presentation

sealed interface MainEvent

class IncreaseNumberEvent: MainEvent

class ColorChangeEvent: MainEvent