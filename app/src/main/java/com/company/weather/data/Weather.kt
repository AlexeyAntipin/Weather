package com.company.weather.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class Weather(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val city: String,
    val date: String,
    val time: String,
    val temp: Int,
    val humidity: Int,
    val feelsLike: Int,
    val windSpeed: Int,
    val minTemp: Int,
    val maxTemp: Int,
    val description: String
)