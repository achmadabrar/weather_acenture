package com.achmadabrar.accenturetest.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class AreaName(
    val cdata: String? = null,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)