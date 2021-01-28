package com.example.simplerecipesapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.simplerecipesapp.MainActivity
import com.example.simplerecipesapp.R
import kotlinx.coroutines.*

class SplashScreenActivity: AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        activityScope.launch {
            delay(3000)
            ContextCompat.startActivity(this@SplashScreenActivity, MainActivity.newIntent(this@SplashScreenActivity), null)
            finish()
        }
    }
}