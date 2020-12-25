package com.achmadabrar.accenturetest.data.database

import androidx.room.*
import com.achmadabrar.accenturetest.data.models.AreaName

@Dao
@TypeConverters(WeatherConverter::class)
interface WeatherDao {
    @Query("SELECT * FROM weather_table")
    suspend fun getAllCity(): List<AreaName>?

    @Query("SELECT * FROM weather_table WHERE `cdata` == :query ")
    suspend fun getCityBytitle(query: String?): AreaName?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(listAreaName: List<AreaName>)
}