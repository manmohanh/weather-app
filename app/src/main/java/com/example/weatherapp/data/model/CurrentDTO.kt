package com.example.weatherapp.data.model

data class CurrentDTO(
    val air_quality: AirQualityDTO?,
    val cloud: Int? = 0,
    val condition: ConditionDTO?,
    val feelslike_c: Double? = 0.0,
    val feelslike_f: Double? = 0.0,
    val gust_kph: Double? = 0.0,
    val gust_mph: Double? = 0.0,
    val humidity: Int? = 0,
    val is_day: Int? = 0,
    val last_updated: String? = null,
    val last_updated_epoch: Int? = 0,
    val precip_in: Double? = 0.0,
    val precip_mm: Double? = 0.0,
    val pressure_in: Double? = 0.0,
    val pressure_mb: Double? = 0.0,
    val temp_c: Double? = 0.0,
    val temp_f: Double? = 0.0,
    val uv: Double? = 0.0,
    val vis_km: Double? = 0.0,
    val vis_miles: Double? = 0.0,
    val wind_degree: Int? = 0,
    val wind_dir: String? = null,
    val wind_kph: Double? = 0.0,
    val wind_mph: Double? = 0.0
)