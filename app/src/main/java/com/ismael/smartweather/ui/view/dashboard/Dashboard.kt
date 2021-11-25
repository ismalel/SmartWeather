package com.ismael.smartweather.ui.view.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismael.smartweather.List
import com.ismael.smartweather.R
import com.ismael.smartweather.databinding.ActivityDashboardBinding
import com.ismael.smartweather.databinding.ActivitySplashViewBinding
import com.ismael.smartweather.ui.adapter.WeatherAdapter
import com.ismael.smartweather.ui.view.splash.SplashMVP
import com.ismael.smartweather.ui.view.splash.SplashPresenter

class Dashboard : AppCompatActivity(), DashboardMVP.View, WeatherAdapter.OnActionListener {
    lateinit var binding: ActivityDashboardBinding
    lateinit var presenter: DashboardMVP.Presenter
    var llmVertical: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llmVertical = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        presenter = DashBoardPresenter(this,this)
        presenter.onGetData()
    }

    override fun showListWeather(weatherList: ArrayList<List>) {
        binding.rvListWeather.layoutManager = llmVertical
        binding.rvListWeather.adapter = WeatherAdapter(weatherList, this)
    }

    override fun onWeatherSelected(weatherList: List) {
        TODO("Not yet implemented")
    }
}