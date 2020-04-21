package com.entimer.coronatracker.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.entimer.coronatracker.R
import com.entimer.coronatracker.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: AppCompatActivity() {
    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter(this)

        initViews()

        presenter.getData(applicationContext)
    }

    private fun initViews() {
        startLoading()
    }

    private fun initListeners() {}

    fun onSuccessGetData() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    fun onFailureGetData() {
        finish()
    }

    fun startLoading() {
        splash_loading.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.anim_updating))
    }
}