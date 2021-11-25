package com.ismael.smartweather

class List (

  var dt         : Int?          = null,
  var main       : Main?         = Main(),
  var weather    : ArrayList<Weather> = arrayListOf(),
  var clouds     : Clouds?       = Clouds(),
  var wind       : Wind?         = Wind(),
  var visibility : Int?          = null,
  var pop        : Double?       = null,
  var rain       : Rain?         = Rain(),
  var sys        : Sys?          = Sys(),
  var dtTxt      : String?       = null

)