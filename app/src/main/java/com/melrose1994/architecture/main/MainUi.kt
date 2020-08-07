package com.melrose1994.architecture.main

import android.content.Context
import android.view.Gravity
import android.view.View
import com.melrose1994.architecture.R
import splitties.views.dsl.core.*
import splitties.views.gravityCenter
import splitties.views.textColorResource
import splitties.views.textResource

/**
 * @author Melrose
 * @since 1.0.0
 */
class MainUi(override val ctx: Context) :Ui{


    private val mainContent = textView {
        textResource = R.string.string_main_title
        textColorResource = R.color.colorPrimary
    }



    override val root = frameLayout {
        fitsSystemWindows  = true

        add(mainContent,lParams{
            gravity = gravityCenter
        })
    }
}