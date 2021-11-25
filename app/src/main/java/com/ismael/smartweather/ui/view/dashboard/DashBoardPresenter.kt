package com.ismael.smartweather.ui.view.dashboard

import android.app.Activity
import com.ismael.smartweather.WeatherDataResponse

class DashBoardPresenter(val activity: Activity, val view: DashboardMVP.View): DashboardMVP.Presenter{
    val interactor: DashboardMVP.Interactor = DashboardInteractor(activity, this)

    override fun onGetData() {
        TODO("Not yet implemented")
    }

    override fun onGetWeatherList(data: WeatherDataResponse) {
        TODO("Not yet implemented")
    }


    override fun onFailure(mssg: String?) {
        TODO("Not yet implemented")
    }
}