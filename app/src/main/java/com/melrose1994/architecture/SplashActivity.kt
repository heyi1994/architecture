package com.melrose1994.architecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import splitties.views.dsl.core.button
import splitties.views.textResource

/**
 * @author Melrose
 * @since 1.0.0
 */
class SplashActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = button {
            textResource = R.string.button_splash_name
        }

        setContentView(button)
    }
}