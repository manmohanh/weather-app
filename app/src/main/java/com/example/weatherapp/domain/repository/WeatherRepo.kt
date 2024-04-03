package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.Weather

interface WeatherRepo {
    suspend fun getWeatherData(city:String):Weather
}