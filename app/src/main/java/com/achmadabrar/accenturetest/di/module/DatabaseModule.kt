package com.achmadabrar.accenturetest.di.module

import android.app.Application
import androidx.room.Room
import com.achmadabrar.accenturetest.data.database.WeatherDao
import com.achmadabrar.accenturetest.data.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): WeatherDatabase {
        return Room
            .databaseBuilder(application, WeatherDatabase::class.java, WeatherDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: WeatherDatabase): WeatherDao {
        return appDataBase.postsDao()
    }
}