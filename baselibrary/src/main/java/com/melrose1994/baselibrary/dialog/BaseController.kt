package com.melrose1994.baselibrary.dialog

import android.content.Context
import com.melrose1994.baselibrary.extend.VoidCallback

/**
 * @author Melrose
 * @since 1.0.0
 */
class BaseController(private val dialog:BaseDialog) {



    class BaseParams(private val context: Context){

        var mCancelable = false

        var mCancelableCallback:VoidCallback?=null

        var mDismissCallback:VoidCallback?=null


        fun apply(controller: BaseController){


        }

    }
}