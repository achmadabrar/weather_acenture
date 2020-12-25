package com.achmadabrar.accenturetest.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.achmadabrar.accenturetest.core.BaseViewModel
import com.achmadabrar.accenturetest.data.database.WeatherDao
import com.achmadabrar.accenturetest.data.models.AreaName
import com.achmadabrar.accenturetest.data.networks.NetworkState
import com.achmadabrar.accenturetest.data.networks.WeatherWorldApi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    val weatherWorldApi: WeatherWorldApi,
    val weatherDao: WeatherDao?
): BaseViewModel<WeatherViewModel>() {

    //caroutine job
    private val supervisorJob = SupervisorJob()

    //network livedata
    val networkLiveData: MutableLiveData<NetworkState> = MutableLiveData()

    //area liveata
    val areaLiveData: MutableLiveData<List<AreaName>> = MutableLiveData()

    //dumy city because the weather not provide city
    val listCity = listOf<AreaName>(
        AreaName("Jakarta"),
        AreaName("Padang"),
        AreaName("London"),
        AreaName("Bali"),
        AreaName("Bandung")
    )

    init {
        ioScope.launch {
            weatherDao?.insertPosts(listCity)
            val city = weatherDao?.getAllCity()
            areaLiveData.postValue(city)
        }
    }

    fun checkQuery(query: String?) {
        ioScope.launch {
            val area = weatherDao?.getCityBytitle(query)
            val areas = mutableListOf<AreaName>()
            if (area == null) {
                networkLiveData.postValue(NetworkState.EMPTY)
            } else {
                areas.add(area)
                areaLiveData.postValue(areas)
            }
        }
    }

    fun loadAllCity() {
        ioScope.launch {
           val areas = weatherDao?.getAllCity()
            areaLiveData.postValue(areas)
        }
    }


    fun getCityFromSearch(areaName: AreaName) {
        ioScope.launch(getJobErrorHandler() + supervisorJob) {
            networkLiveData.postValue(NetworkState.LOADING)
            val data = weatherWorldApi.getDataCity()

        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Log.e("errorFailed", "An error happened: $e")
        networkLiveData.postValue(NetworkState.FAILED)
        networkLiveData.postValue(NetworkState.fialed(e.localizedMessage))
    }

}