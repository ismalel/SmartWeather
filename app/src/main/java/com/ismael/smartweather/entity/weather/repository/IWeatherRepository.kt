package com.ismael.smartweather.entity.weather.repository

import com.ismael.smartweather.WeatherDataResponse
import io.reactivex.Observable

interface IWeatherRepository {
    fun forecast(id: String?, cnt: Int, appid: String?): Observable<WeatherDataResponse>
}