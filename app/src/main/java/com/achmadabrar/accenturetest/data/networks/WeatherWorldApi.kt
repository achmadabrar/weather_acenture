package com.achmadabrar.accenturetest.data.networks

import com.achmadabrar.accenturetest.data.models.SearchResponse
import retrofit2.http.GET

interface WeatherWorldApi {

    companion object {
        private const val SEARCH = "search.ashx"
    }

    @GET(SEARCH)
    suspend fun getDataCity(

    ): SearchResponse

}