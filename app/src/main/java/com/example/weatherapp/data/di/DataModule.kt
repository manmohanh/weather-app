package com.example.weatherapp.data.di

import com.example.weatherapp.data.network.ApiService
import com.example.weatherapp.data.network.NetworkConstants.BASE_URL
import com.example.weatherapp.data.repository.WeatherRepoImpl
import com.example.weatherapp.domain.repository.WeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideApiService():ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepo(apiService: ApiService):WeatherRepo {
        return WeatherRepoImpl(apiService)
    }
}