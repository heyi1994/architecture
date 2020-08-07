package com.melrose1994.baselibrary.dialog

import android.app.Dialog
import android.content.Context

/**
 * @author Melrose
 * @since 1.0.0
 */
class BaseDialog(context: Context): Dialog(context) {

     val mController:BaseController


    init {
        mController = BaseController(this)
    }




     class Builder(private val context: Context){

         private val P:BaseController.BaseParams

         init {
             P = BaseController.BaseParams(context)

         }


         fun create() :BaseDialog{
             val dialog = BaseDialog(context)
             P.apply(dialog.mController)
             dialog.setCancelable(P.mCancelable)
             return  dialog
         }
     }
}