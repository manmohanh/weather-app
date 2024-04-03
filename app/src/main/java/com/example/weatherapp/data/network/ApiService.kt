package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NetworkConstants.GET_WEATHER)
    suspend fun getWeatherData(
        @Query("q") city: String
    ): WeatherDTO?
}