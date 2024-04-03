package com.example.weatherapp.data.model

data class AirQualityDTO(
    val co: Double? = 0.0,
    val no2: Double? = 0.0,
    val o3: Double? = 0.0,
    val pm10: Double? = 0.0,
    val pm2_5: Double? = 0.0,
    val so2: Double? = 0.0
)