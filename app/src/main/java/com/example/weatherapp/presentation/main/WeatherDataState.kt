package com.example.weatherapp.presentation.main

import com.example.weatherapp.domain.model.Weather

data class WeatherDataState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Weather? = null
)
