package com.melrose1994.baselibrary.dialog.alert

import android.content.Context
import android.view.Gravity
import androidx.annotation.StringRes
import com.melrose1994.baselibrary.dialog.BaseDialog

/**
 * @author Melrose
 * @since 1.0.0
 */
class AlertDialog (val cxt: Context){

    private val ui:AlertUi = AlertUi(cxt)

    private val dialog:BaseDialog

    private val mAlert:AlertController


    init {
        dialog = BaseDialog.Builder(cxt).apply {
            applyAnimation()
            applyRootViewSize(true)
            applyRootViewGravity(Gravity.BOTTOM)
            setContentView(ui.root)
        }.create()
        mAlert = AlertController(this,ui)
    }






    class Builder(private val context: Context){

        private val P = AlertController.AlertParams(context)


        fun create():AlertDialog{
            val dialog = AlertDialog(context)
            P.apply(dialog.mAlert)
            return dialog
        }


        fun setMessage(message:CharSequence):Builder{
            P.mMessage = message
            return this
        }

        fun setMessage(@StringRes messageResId:Int):Builder{
            P.mMessageResId = messageResId
            return this
        }


        fun setTitle(title:CharSequence):Builder{
            P.mTitle = title
            return this
        }

        fun setTitle(@StringRes titleResId:Int):Builder{
            P.mTitleResId = titleResId
            return this
        }
    }


}