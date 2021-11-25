package com.ismael.smartweather.ui.view.detailWeather

import android.app.Activity
import com.ismael.smartweather.*
import com.ismael.smartweather.data.local.AppPreferences

class DetailWeatherPresenter(val activity: Activity, val view: DetailWeatherMVP.View) : DetailWeatherMVP.Presenter{

    val prefs: AppPreferences = AppPreferences(activity)

    override fun onClickButton() {
        view.onClosedActivity()
    }

    override fun initWeatherData() {
        val weatherData : WeatherData = WeatherData()
        val weather : Weather = Weather()
        val main : Main = Main()
        val clouds: Clouds = Clouds(prefs.clouds)
        val wind: Wind = Wind()


        weather.main = prefs.weather
        weather.description = prefs.weatherType
        main.temp = prefs.temp
        main.temp_min = prefs.tempMin
        main.temp_max = prefs.tempMax
        wind.speed = prefs.wind

        weatherData.weather.add(weather)
        weatherData.main = main
        weatherData.clouds = clouds
        weatherData.wind = wind

        view.onShowWeatherInfo(weatherData)

    }

}