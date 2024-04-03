package com.example.weatherapp.data.model

data class LocationDTO(
    val country: String? = null,
    val lat: Double? = 0.0,
    val localtime: String? = null,
    val localtime_epoch: Int? = 0,
    val lon: Double? = 0.0,
    val name: String? = null,
    val region: String? = null,
    val tz_id: String? = null
)