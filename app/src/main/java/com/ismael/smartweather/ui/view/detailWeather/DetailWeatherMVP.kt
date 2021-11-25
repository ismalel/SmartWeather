package com.ismael.smartweather.ui.view.detailWeather

import com.ismael.smartweather.WeatherData

interface DetailWeatherMVP {

    interface View{
        fun onClosedActivity()
        fun onShowWeatherInfo(weather: WeatherData)
    }

    interface Presenter{
        fun onClickButton()
        fun initWeatherData()
    }

}