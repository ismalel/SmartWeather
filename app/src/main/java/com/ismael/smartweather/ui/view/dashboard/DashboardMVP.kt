package com.ismael.smartweather.ui.view.dashboard

import com.ismael.smartweather.WeatherData
import com.ismael.smartweather.WeatherDataResponse

interface DashboardMVP{

    interface View{
        fun showListWeather(weatherData: ArrayList<WeatherData>)
        fun showMessage(mssg: String)
        fun onShowCityName(city: String?)
        fun changeView()
    }

    interface Presenter{
        fun onGetData()
        fun onGetWeatherList(data: WeatherDataResponse)
        fun onFailure(mssg: String)
        fun saveWeather(weather: WeatherData)
    }

    interface Interactor{
        fun getListWeather(id:String?,ctn:Int,appid:String?,units: String?)
    }

}