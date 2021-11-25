package com.ismael.smartweather.ui.view.dashboard

import android.app.Activity
import com.ismael.smartweather.entity.weather.repository.IWeatherRepository
import com.ismael.smartweather.entity.weather.repository.WeatherRepository

class DashboardInteractor(val activity: Activity, val presenter: DashBoardPresenter): DashboardMVP.Interactor{
    val weatherRepository: IWeatherRepository = WeatherRepository()

    override fun getListWeather(id: String?, ctn: Int, appid: String?,units:String?) {
        weatherRepository.forecast(id, ctn, appid,units)
            .subscribe({ listWeather->
                presenter.onGetWeatherList(listWeather)
            }){ throwable: Throwable->
                presenter.onFailure(throwable.message.toString())
            }
    }
}