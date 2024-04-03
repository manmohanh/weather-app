package com.example.weatherapp.domain.use_case

import com.example.weatherapp.common.Resource
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(private val weatherRepo: WeatherRepo) {

    operator fun invoke(city:String): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = weatherRepo.getWeatherData(city = city)))
        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}