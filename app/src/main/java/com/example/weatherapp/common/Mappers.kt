package com.example.weatherapp.common

import com.example.weatherapp.data.model.AirQualityDTO
import com.example.weatherapp.data.model.AlertsDTO
import com.example.weatherapp.data.model.AstroDTO
import com.example.weatherapp.data.model.ConditionDTO
import com.example.weatherapp.data.model.CurrentDTO
import com.example.weatherapp.data.model.DayDTO
import com.example.weatherapp.data.model.ForecastDTO
import com.example.weatherapp.data.model.ForecastdayDTO
import com.example.weatherapp.data.model.HourDTO
import com.example.weatherapp.data.model.LocationDTO
import com.example.weatherapp.data.model.WeatherDTO
import com.example.weatherapp.domain.model.AirQuality
import com.example.weatherapp.domain.model.Alerts
import com.example.weatherapp.domain.model.Astro
import com.example.weatherapp.domain.model.Condition
import com.example.weatherapp.domain.model.Current
import com.example.weatherapp.domain.model.Day
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.Forecastday
import com.example.weatherapp.domain.model.Hour
import com.example.weatherapp.domain.model.Location
import com.example.weatherapp.domain.model.Weather


fun WeatherDTO.toDomain():Weather {
    return Weather(
        alerts = alerts?.toDomain()?: Alerts(emptyList()),
        current = current?.toDomain()?: Current(
            AirQuality(0.0,0.0,0.0,0.0,0.0,0.0),
            0,
            Condition(0,"",""),
            0.0,
            0.0,
            0.0,
            0.0,
            0,
            0,
            "",
            0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0,
            "",
            0.0,
            0.0
        ),
        forecast = forecast?.toDomain()?: Forecast(emptyList()),
        location = location?.toDomain()?: Location(
            "",
            0.0,
            "",
            0,
            0.0,
            "",
            "",
            ""
        )
    )
}

fun AirQualityDTO.toDomain(): AirQuality {
    return AirQuality(
        co = co ?: 0.0,
        no2 = no2 ?: 0.0,
        o3 = o3 ?: 0.0,
        pm10 = pm10 ?: 0.0,
        pm2_5 = pm2_5 ?: 0.0,
        so2 = so2 ?: 0.0
    )
}

fun AlertsDTO.toDomain(): Alerts {
    return Alerts(
        alert = alert?.map { it } ?: emptyList()
    )
}

fun AstroDTO.toDomain(): Astro {
    return Astro(
        is_moon_up = is_moon_up ?: 0,
        is_sun_up = is_sun_up ?: 0,
        moon_illumination = moon_illumination ?: 0,
        moon_phase = moon_phase ?: "",
        moonrise = moonrise ?: "",
        moonset = moonset ?: "",
        sunrise = sunrise ?: "",
        sunset = sunset ?: ""
    )
}

fun CurrentDTO.toDomain(): Current {
    return Current(
        air_quality = air_quality?.toDomain() ?: AirQuality(
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        ),
        cloud = cloud ?: 0,
        condition = condition?.toDomain() ?: Condition(0, "", ""),
        feelslike_c = feelslike_c ?: 0.0,
        feelslike_f = feelslike_f ?: 0.0,
        gust_kph = gust_kph ?: 0.0,
        gust_mph = gust_mph ?: 0.0,
        humidity = humidity ?: 0,
        is_day = is_day ?: 0,
        last_updated = last_updated ?: "",
        last_updated_epoch = last_updated_epoch ?: 0,
        precip_in = precip_in ?: 0.0,
        precip_mm = precip_mm ?: 0.0,
        pressure_in = pressure_in ?: 0.0,
        pressure_mb = pressure_mb ?: 0.0,
        temp_c = temp_c ?: 0.0,
        temp_f = temp_f ?: 0.0,
        uv = uv ?: 0.0,
        vis_km = vis_km ?: 0.0,
        vis_miles = vis_miles ?: 0.0,
        wind_degree = wind_degree ?: 0,
        wind_dir = wind_dir ?: "",
        wind_kph = wind_kph ?: 0.0,
        wind_mph = wind_mph ?: 0.0
    )
}

fun LocationDTO.toDomain(): Location {
    return Location(
        country = country ?: "",
        lat = lat ?: 0.0,
        localtime = localtime ?: "",
        lon = lon ?: 0.0,
        localtime_epoch = localtime_epoch ?: 0,
        name = name ?: "",
        region = region ?: "",
        tz_id = tz_id ?: ""

    )
}

fun ConditionDTO.toDomain(): Condition {
    return Condition(
        code = code ?: 0,
        icon = icon ?: "",
        text = text ?: ""
    )
}

fun HourDTO.toDomain(): Hour {
    return Hour(
        chance_of_rain = chance_of_rain ?: 0,
        chance_of_snow = chance_of_snow ?: 0,
        cloud = cloud ?: 0,
        condition = condition?.toDomain() ?: Condition(0, "", ""),
        dewpoint_c = dewpoint_c ?: 0.0,
        dewpoint_f = dewpoint_f ?: 0.0,
        feelslike_c = feelslike_c ?: 0.0,
        feelslike_f = feelslike_f ?: 0.0,
        gust_kph = gust_kph ?: 0.0,
        gust_mph = gust_mph ?: 0.0,
        heatindex_c = heatindex_c ?: 0.0,
        heatindex_f = heatindex_f ?: 0.0,
        humidity = humidity ?: 0,
        is_day = is_day ?: 0,
        precip_in = precip_in ?: 0.0,
        precip_mm = precip_mm ?: 0.0,
        pressure_in = pressure_in ?: 0.0,
        pressure_mb = pressure_mb ?: 0.0,
        snow_cm = snow_cm ?: 0.0,
        temp_c = temp_c ?: 0.0,
        temp_f = temp_f ?: 0.0,
        time = time ?: "",
        time_epoch = time_epoch ?: 0,
        uv = uv ?: 0.0,
        vis_km = vis_km ?: 0.0,
        vis_miles = vis_miles ?: 0.0,
        will_it_rain = will_it_rain ?: 0,
        will_it_snow = will_it_snow ?: 0,
        wind_degree = wind_degree ?: 0,
        wind_dir = wind_dir ?: "",
        wind_kph = wind_kph ?: 0.0,
        wind_mph = wind_mph ?: 0.0,
        windchill_c = windchill_c ?: 0.0,
        windchill_f = windchill_f ?: 0.0
    )
}
fun DayDTO.toDomain(): Day {
    return Day(
        avghumidity = avghumidity ?: 0,
        avgtemp_c = avgtemp_c ?: 0.0,
        avgtemp_f = avgtemp_f ?: 0.0,
        avgvis_km = avgvis_km ?: 0.0,
        avgvis_miles = avgvis_miles ?: 0.0,
        condition = condition?.toDomain() ?: Condition(0, "", ""),
        daily_chance_of_rain = daily_chance_of_rain ?: 0,
        daily_chance_of_snow = daily_chance_of_snow ?: 0,
        daily_will_it_rain = daily_will_it_rain ?: 0,
        daily_will_it_snow = daily_will_it_snow ?: 0,
        maxtemp_c = maxtemp_c ?: 0.0,
        maxtemp_f = maxtemp_f ?: 0.0,
        maxwind_kph = maxwind_kph ?: 0.0,
        maxwind_mph = maxwind_mph ?: 0.0,
        mintemp_c = mintemp_c ?: 0.0,
        mintemp_f = mintemp_f ?: 0.0,
        totalprecip_in = totalprecip_in ?: 0.0,
        totalprecip_mm = totalprecip_mm ?: 0.0,
        totalsnow_cm = totalsnow_cm ?: 0.0,
        uv = uv ?: 0.0
    )
}
fun ForecastdayDTO.toDomain():Forecastday {
    return Forecastday(
        astro = astro?.toDomain() ?: Astro(
            0,
            0,
            0,
            "",
            "",
            "",
            "",
            ""
        ), date = date ?: "", date_epoch = date_epoch ?: 0, day = day?.toDomain() ?: Day(
            0,
            0.0,
            0.0,
            0.0,
            0.0,
            Condition(0, "", ""),
            0,
            0,
            0,
            0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        ), hour = emptyList()
    )
}

fun ForecastDTO.toDomain(): Forecast {
    return Forecast(
        forecastday = forecastday?.map { it.toDomain() } ?: emptyList()
    )
}