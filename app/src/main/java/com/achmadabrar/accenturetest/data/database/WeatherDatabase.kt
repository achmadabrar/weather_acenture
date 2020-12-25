package com.achmadabrar.accenturetest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.achmadabrar.accenturetest.data.models.AreaName

@Database(
    entities = [AreaName::class],
    version = 1,
    exportSchema = true
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun postsDao(): WeatherDao

    companion object {

        private var instance: WeatherDatabase? = null
        private val LOCK = Any()
        const val DB_NAME = "weather.db"

        @JvmStatic
        fun getInstance(context: Context): WeatherDatabase {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            WeatherDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
                return instance!!
            }
        }
    }
}