package com.ismael.smartweather.data.local

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val appData: SharedPreferences = context.getSharedPreferences("SharedData", Context.MODE_PRIVATE)
    private var appEdit: SharedPreferences.Editor? = null


    var weather: String?
        get() = appData.getString("weather", "")
        set(weather) {
            appEdit = appData.edit()
            appEdit?.putString("weather", weather)
            appEdit?.apply()
        }
    var weatherType: String?
        get() = appData.getString("weatherType", "")
        set(weatherType) {
            appEdit = appData.edit()
            appEdit?.putString("weatherType", weatherType)
            appEdit?.apply()
        }
    var temp: Double?
        get() = Double.fromBits(appData.getLong("temp",0))
        set(temp) {
            appEdit = appData.edit()
            appEdit?.putLong("temp", temp!!.toRawBits())
            appEdit?.apply()
        }
    var tempMin: Double?
        get() = Double.fromBits(appData.getLong("tempMin",0))
        set(tempMin) {
            appEdit = appData.edit()
            appEdit?.putLong("tempMin", tempMin!!.toRawBits())
            appEdit?.apply()
        }
    var tempMax: Double?
        get() = Double.fromBits(appData.getLong("tempMax",0))
        set(tempMax) {
            appEdit = appData.edit()
            appEdit?.putLong("tempMax", tempMax!!.toRawBits())
            appEdit?.apply()
        }

    var clouds: Int?
        get() = appData.getInt("clouds",0)
        set(clouds) {
            appEdit = appData.edit()
            appEdit?.putInt("clouds", clouds!!)
            appEdit?.apply()
        }

    var wind: Double?
        get() = Double.fromBits(appData.getLong("wind",0))
        set(wind) {
            appEdit = appData.edit()
            appEdit?.putLong("wind", wind!!.toRawBits())
            appEdit?.apply()
        }
}