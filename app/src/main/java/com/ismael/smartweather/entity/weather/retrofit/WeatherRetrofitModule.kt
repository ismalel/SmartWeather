package com.ismael.smartweather.entity.weather.retrofit

import com.ismael.smartweather.data.remote.RetrofitClient
import retrofit2.Retrofit

class WeatherRetrofitModule {

    fun forecast() : IWeatherAPI.Climate{
        return RetrofitClient().getRetrofitInstance(RetrofitClient().getURLApi())!!.create(IWeatherAPI.Climate::class.java)
    }
}