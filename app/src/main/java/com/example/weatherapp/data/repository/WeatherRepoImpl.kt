package com.example.weatherapp.data.repository

import com.example.weatherapp.common.toDomain
import com.example.weatherapp.data.network.ApiService
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepo
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(private val apiService: ApiService):WeatherRepo {
    override suspend fun getWeatherData(city:String): Weather {
        return apiService.getWeatherData(city)!!.toDomain()
    }
}