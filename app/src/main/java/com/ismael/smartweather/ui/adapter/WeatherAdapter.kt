package com.ismael.smartweather.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.smartweather.WeatherData
import com.ismael.smartweather.databinding.ItemWeatherBinding

class WeatherAdapter (
    private val data: ArrayList<WeatherData>,
    val onActionListener: OnActionListener
): RecyclerView.Adapter<WeatherAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private var binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        var index = 0;
        fun bind(weatherData: WeatherData) {
            binding.tvDate.text = "Date: " + weatherData.dt_txt
            binding.tvWeather.text = "Weather: " + weatherData.weather.get(0).main
            binding.cvWeatherItem.setOnClickListener { onActionListener.onWeatherSelected(weatherData) }
        }
    }

    interface OnActionListener{
        fun onWeatherSelected(weatherData: WeatherData)
    }
}