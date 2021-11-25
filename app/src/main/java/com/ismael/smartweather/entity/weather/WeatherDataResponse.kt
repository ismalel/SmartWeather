package com.ismael.smartweather




data class WeatherDataResponse (

  var cod     : String?    = null,
  var city    : City?      = City(),
  var message : Double?    = null,
  var list   : ArrayList<WeatherData> = arrayListOf()

)