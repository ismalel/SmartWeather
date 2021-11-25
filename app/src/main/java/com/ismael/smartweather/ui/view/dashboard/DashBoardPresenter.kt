package com.ismael.smartweather.ui.view.dashboard

import android.app.Activity
import com.ismael.smartweather.WeatherData
import com.ismael.smartweather.WeatherDataResponse
import com.ismael.smartweather.data.local.AppPreferences

class DashBoardPresenter(val activity: Activity, val view: DashboardMVP.View): DashboardMVP.Presenter{
    val interactor: DashboardMVP.Interactor = DashboardInteractor(activity, this)
    val prefs: AppPreferences = AppPreferences(activity)

    override fun onGetData() {
        interactor.getListWeather("3523212", 7,"e357d51a2410223144843e2e5a0e39ae","metric")
    }

    override fun onGetWeatherList(data: WeatherDataResponse) {
        val weatherData: ArrayList<WeatherData> = data.list
        view.onShowCityName(data.city!!.name)
        view.showListWeather(weatherData)
    }


    override fun onFailure(mssg: String) {
       view.showMessage(mssg)
    }

    override fun saveWeather(weather: WeatherData) {
        prefs.weather = weather.weather.get(0).main
        prefs.weatherType = weather.weather.get(0).description
        prefs.temp = weather.main!!.temp
        prefs.tempMin = weather.main!!.temp_min
        prefs.tempMax = weather.main!!.temp_max
        prefs.clouds = weather.clouds!!.all
        prefs.wind = weather.wind!!.speed

        view.changeView()
    }
}