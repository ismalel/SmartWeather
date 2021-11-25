package com.ismael.smartweather.ui.view.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismael.smartweather.WeatherData
import com.ismael.smartweather.databinding.ActivityDashboardBinding
import com.ismael.smartweather.ui.adapter.WeatherAdapter
import com.ismael.smartweather.ui.view.detailWeather.DetailWeather

class Dashboard : AppCompatActivity(), DashboardMVP.View, WeatherAdapter.OnActionListener {
    lateinit var binding: ActivityDashboardBinding
    lateinit var presenter: DashboardMVP.Presenter
    var llmVertical: LinearLayoutManager? = null
    var city: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llmVertical = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        presenter = DashBoardPresenter(this, this)
        presenter.onGetData()
    }

    override fun showListWeather(weatherData: ArrayList<WeatherData>) {
        binding.rvListWeather.layoutManager = llmVertical
        binding.rvListWeather.adapter = WeatherAdapter(weatherData, this)
    }

    override fun showMessage(mssg: String) {
        Toast.makeText(this, mssg, Toast.LENGTH_LONG).show()
    }

    override fun onShowCityName(city: String?) {
        binding.tvCity.text = city
    }

    override fun changeView() {
        val intent = Intent(this, DetailWeather::class.java)
        startActivity(intent)
    }


    override fun onWeatherSelected(weatherData: WeatherData) {
        presenter.saveWeather(weatherData)
    }
}