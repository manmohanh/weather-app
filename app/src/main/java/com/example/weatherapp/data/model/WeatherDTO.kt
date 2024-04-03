package com.example.weatherapp.data.model

data class WeatherDTO(
    val alerts: AlertsDTO?,
    val current: CurrentDTO?,
    val forecast: ForecastDTO?,
    val location: LocationDTO?
)