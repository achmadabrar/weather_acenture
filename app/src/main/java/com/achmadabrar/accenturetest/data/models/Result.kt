package com.achmadabrar.accenturetest.data.models

data class Result(
    val country: Country? = null,
    val areaName: AreaName? = null,
    val latitude: String? = null,
    val region: Region? = null,
    val longitude: String? = null,
    val population: String? = null,
    val weatherUrl: WeatherUrl? = null
)