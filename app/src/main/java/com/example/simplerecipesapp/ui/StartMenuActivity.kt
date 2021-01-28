package com.example.simplerecipesapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.simplerecipesapp.MainActivity
import com.example.simplerecipesapp.R
import kotlinx.android.synthetic.main.activity_start_menu.*

/**
 * Main menu activity
 */
class StartMenuActivity: AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, StartMenuActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_menu)

        //onClick listener for RecipesActivity
        recipes_btn.setOnClickListener {
            ContextCompat.startActivity(this@StartMenuActivity, MainActivity.newIntent(this@StartMenuActivity), null)
        }
    }
}