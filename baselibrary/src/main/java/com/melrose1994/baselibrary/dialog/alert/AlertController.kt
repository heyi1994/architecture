package com.melrose1994.baselibrary.dialog.alert

import android.content.Context
import androidx.annotation.StringRes

/**
 * @author Melrose
 * @since 1.0.0
 */

class AlertController (private val dialog: AlertDialog,private val ui: AlertUi){











    class AlertParams(private val context: Context){

        var mMessage:CharSequence?=null
        var mTitle:CharSequence?=null
        @StringRes var mMessageResId:Int = 0
        @StringRes var mTitleResId:Int = 0


        fun apply(dialog: AlertController){

        }
    }
}