package com.example.weatherapp.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.common.Resource
import com.example.weatherapp.domain.use_case.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
):ViewModel() {

    private val _weatherData = mutableStateOf(WeatherDataState())
    val weatherData: State<WeatherDataState>  = _weatherData

    fun getWeatherData(city:String){
        getWeatherDataUseCase(city).onEach {
            when(it){
                is Resource.Error -> {
                    _weatherData.value = WeatherDataState(error = it.data.toString())
                }
                is Resource.Loading -> {
                    _weatherData.value = WeatherDataState(isLoading = true)
                }
                is Resource.Success -> {
                    _weatherData.value = WeatherDataState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}