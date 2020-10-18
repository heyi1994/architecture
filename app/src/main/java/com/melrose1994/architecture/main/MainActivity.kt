package com.melrose1994.architecture.main

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import splitties.views.dsl.core.setContentView

/**
 * @author Melrose
 * @since 1.0.0
 */
class MainActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ui = MainUi(this)
        setContentView(ui)

        
    }
}