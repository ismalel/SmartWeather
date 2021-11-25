package com.ismael.smartweather.ui.view.splash

interface SplashMVP {

    interface View{
        fun openDashboard()

    }

    interface Presenter{
        fun onOpenDashboard()
    }
}