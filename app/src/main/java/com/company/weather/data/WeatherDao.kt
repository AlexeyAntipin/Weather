package com.company.weather.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWeather(weather: Weather)

    @Query("SELECT * FROM weather_table ORDER BY id ASC")
    fun readAddData(): LiveData<List<Weather>>
}