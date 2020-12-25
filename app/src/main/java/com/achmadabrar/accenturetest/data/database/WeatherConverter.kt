package com.achmadabrar.accenturetest.data.database

import androidx.room.TypeConverter
import com.achmadabrar.accenturetest.data.models.AreaName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WeatherConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun mutableListToString(string: MutableList<AreaName>): String {
            val type = object : TypeToken<MutableList<AreaName>>() {}.type
            return Gson().toJson(string, type)
        }

        @TypeConverter
        @JvmStatic
        fun stringToMutableList(string: String): MutableList<AreaName> {
            val type = object : TypeToken<MutableList<AreaName>>() {}.type
            return Gson().fromJson(string, type)
        }
    }
}