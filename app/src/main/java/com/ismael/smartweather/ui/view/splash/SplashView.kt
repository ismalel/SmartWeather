package com.ismael.smartweather.ui.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ismael.smartweather.databinding.ActivitySplashViewBinding
import com.ismael.smartweather.ui.view.dashboard.Dashboard

class SplashView : AppCompatActivity(), SplashMVP.View {

    lateinit var binding: ActivitySplashViewBinding
    lateinit var presenter: SplashMVP.Presenter
    val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = SplashPresenter(this, this)
        presenter.onOpenDashboard()
    }

    override fun openDashboard() {
        Handler().postDelayed({
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}