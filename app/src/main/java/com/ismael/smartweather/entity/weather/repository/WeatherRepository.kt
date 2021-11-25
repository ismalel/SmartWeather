package com.ismael.smartweather.entity.weather.repository

import com.ismael.smartweather.WeatherDataResponse
import com.ismael.smartweather.entity.weather.retrofit.WeatherRetrofitModule
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepository: IWeatherRepository {
    var weatherRetrofitModule: WeatherRetrofitModule = WeatherRetrofitModule()

    override fun forecast(id: String?, cnt: Int, appid: String?, units: String?): Observable<WeatherDataResponse> {
        return weatherRetrofitModule.forecast()
            .forecast(id,cnt,appid,units)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.flatMap { weatherData ->
                if(weatherData.cod.equals("200")){
                    return@flatMap Observable.just(weatherData)
                }else{
                    throw Exception(weatherData.cod)
                }
            }!!
    }
}