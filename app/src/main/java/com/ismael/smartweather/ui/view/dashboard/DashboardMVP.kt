package com.ismael.smartweather.ui.view.dashboard

import com.ismael.smartweather.List
import com.ismael.smartweather.WeatherDataResponse

interface DashboardMVP{

    interface View{
        fun showListWeather(weatherList: ArrayList<List>)
    }

    interface Presenter{
        fun onGetData()
        fun onGetWeatherList(data: WeatherDataResponse)
        fun onFailure(mssg: String?)
    }

    interface Interactor{
        fun getListWeather(id:String?,ctn:Int,appid:String?)
    }

}