package com.example.weatherapp.domain.di

import com.example.weatherapp.domain.repository.WeatherRepo
import com.example.weatherapp.domain.use_case.GetWeatherDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideWeatherDataUseCase(weatherRepo: WeatherRepo):GetWeatherDataUseCase {
        return GetWeatherDataUseCase(weatherRepo)
    }
}