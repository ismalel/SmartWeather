package com.ismael.smartweather.ui.view.detailWeather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ismael.smartweather.R
import com.ismael.smartweather.WeatherData

import com.ismael.smartweather.databinding.ActivityDetailWeatherBinding
import com.ismael.smartweather.ui.view.dashboard.DashBoardPresenter
import com.ismael.smartweather.ui.view.dashboard.DashboardMVP

class DetailWeather : AppCompatActivity() , DetailWeatherMVP.View {
    lateinit var binding: ActivityDetailWeatherBinding
    lateinit var presenter: DetailWeatherMVP.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = DetailWeatherPresenter(this,this)
        presenter.initWeatherData()

        binding.btnDetail.setOnClickListener{presenter.onClickButton()}


    }

    override fun onClosedActivity() {
        finish()
    }

    override fun onShowWeatherInfo(weather: WeatherData) {
        binding.tvWeather.text = "Weather: " + weather.weather.get(0).main
        binding.tvTypeWeather.text = "Type: " + weather.weather.get(0).description
        binding.tvTemp.text = "Temp: " + weather.main!!.temp + " C"
        binding.tvTempMin.text = "Temp MIN : " + weather!!.main!!.temp_min + " C"
        binding.tvTempMax.text = "Temp MAX : " + weather!!.main!!.temp_max + " C"
        binding.tvClouds.text = "Clouds: " + weather!!.clouds!!.all + "%"
        binding.tvWind.text = "Wind: " + weather!!.wind!!.speed +" m/s"
    }


}