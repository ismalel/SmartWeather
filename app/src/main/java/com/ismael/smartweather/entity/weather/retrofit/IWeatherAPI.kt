package com.ismael.smartweather.entity.weather.retrofit

import com.ismael.smartweather.WeatherDataResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface IWeatherAPI {

    interface Climate {
        @GET("forecast")
        fun forecast(@Query("id") id: String?,
                     @Query("cnt") cnt: Int,
                     @Query("appid") apiKey: String?,
                     @Query("units") units: String?) : Observable<WeatherDataResponse>
    }
}