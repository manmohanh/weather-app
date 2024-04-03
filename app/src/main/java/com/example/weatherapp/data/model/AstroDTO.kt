package com.example.weatherapp.data.model

data class AstroDTO(
    val is_moon_up: Int? = 0,
    val is_sun_up: Int? = 0,
    val moon_illumination: Int? = 0,
    val moon_phase: String? = null,
    val moonrise: String? = null,
    val moonset: String? = null,
    val sunrise: String? = null,
    val sunset: String? = null
)