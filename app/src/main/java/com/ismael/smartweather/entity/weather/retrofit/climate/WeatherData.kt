package com.ismael.smartweather

import java.util.*
import kotlin.collections.ArrayList

class WeatherData (

  var dt         : Int?          = null,
  var main       : Main?         = Main(),
  var weather    : ArrayList<Weather> = arrayListOf(),
  var clouds     : Clouds?       = Clouds(),
  var wind       : Wind?         = Wind(),
  var visibility : Int?          = null,
  var pop        : Double?       = null,
  var rain       : Rain?         = Rain(),
  var sys        : Sys?          = Sys(),
  var dt_txt      : String?       = null

)