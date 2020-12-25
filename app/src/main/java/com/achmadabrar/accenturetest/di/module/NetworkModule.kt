package com.achmadabrar.accenturetest.di.module

import com.achmadabrar.accenturetest.data.networks.WeatherWorldApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providePostApi(retrofit: Retrofit): WeatherWorldApi {
        return retrofit.create(WeatherWorldApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }

    @Provides
    fun provideRetrofitInterface(
        client: OkHttpClient
    ): Retrofit {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        return Retrofit.Builder()
            .baseUrl("http://api.worldweatheronline.com/premium/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


}