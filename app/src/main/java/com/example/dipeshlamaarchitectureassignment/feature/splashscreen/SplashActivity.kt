package com.example.dipeshlamaarchitectureassignment.feature.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dipeshlamaarchitectureassignment.R
import com.example.dipeshlamaarchitectureassignment.feature.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashDelayHandler()
    }

    private fun splashDelayHandler (){
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },2000)
    }
}