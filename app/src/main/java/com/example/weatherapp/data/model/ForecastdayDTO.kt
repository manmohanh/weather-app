package com.example.weatherapp.data.model

data class ForecastdayDTO(
    val astro: AstroDTO?,
    val date: String?=null,
    val date_epoch: Int?=0,
    val day: DayDTO?,
    val hour: List<HourDTO>?
)