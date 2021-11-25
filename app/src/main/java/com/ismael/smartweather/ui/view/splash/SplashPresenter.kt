package com.ismael.smartweather.ui.view.splash

import android.app.Activity

class SplashPresenter(val activity: Activity, val view : SplashMVP.View) : SplashMVP.Presenter {


    override fun onOpenDashboard() {
        view.openDashboard()
    }
}