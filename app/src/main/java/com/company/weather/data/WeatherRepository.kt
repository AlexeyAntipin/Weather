package com.company.weather.data

import androidx.lifecycle.LiveData

class WeatherRepository(private val weatherDao: WeatherDao) {

    val readAllData: LiveData<List<Weather>> = weatherDao.readAddData()

    suspend fun addWeather(weather: Weather) {
        weatherDao.addWeather(weather)
    }
}