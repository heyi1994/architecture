package com.melrose1994.baselibrary.dialog

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.StyleRes
import com.melrose1994.baselibrary.R
import com.melrose1994.baselibrary.base.VoidCallback
import com.melrose1994.baselibrary.bean.AnimGravity
import kotlin.IllegalArgumentException

/**
 * @author Melrose
 * @since 1.0.0
 */
class BaseController( val dialog:BaseDialog, val window:Window) {



    class BaseParams(private val context: Context){

        /**
         * [mCancelable]是否可取消 ;
         */
        var mCancelable = false

        /**
         * 取消监听 ;
         */
        var mCancelableCallback:VoidCallback?=null

        /**
         * 消失监听 ;
         */
        var mDismissCallback: VoidCallback?=null

        /**
         * [mHasMask]未填充区域是否有半透明遮罩 ;
         */
        var mHasMask = true


        var mView:View?=null


        var mAnimGravity: AnimGravity = AnimGravity.DEFAULT


        var mWidthFullScreen = false
        var mHeightFullScreen = false

        var mRootGravity:Int = Gravity.CENTER

        @StyleRes var mAnimStyleRes:Int = 0
        /**
         * #### 绑定和设置参数 ;
         */
        @Throws(IllegalArgumentException::class)
        fun apply(controller: BaseController){
          if (mView == null)throw IllegalArgumentException("The dialog's View is null!")
          controller.dialog.setCancelable(mCancelable)
          controller.dialog.setOnDismissListener { mDismissCallback?.run() }
          controller.dialog.setOnCancelListener { mCancelableCallback?.run() }


          if (mAnimGravity != AnimGravity.DEFAULT) {
              controller.window.setWindowAnimations(
                  when (mAnimGravity) {
                      AnimGravity.BI_BO -> R.style.window_bi_bo_style
                      AnimGravity.BI_TO -> R.style.window_bi_to_style

                      AnimGravity.TI_TO -> R.style.window_ti_to_style
                      AnimGravity.TI_BO -> R.style.window_ti_bo_style
                      AnimGravity.CUSTOM -> {
                          if (mAnimStyleRes == 0) throw IllegalArgumentException("Not set the value of mAnimStyleRes !")
                          mAnimStyleRes
                      }
                      AnimGravity.LI_LO -> R.style.window_li_lo_style
                      AnimGravity.LI_RO -> R.style.window_li_ro_style
                      AnimGravity.RI_RO -> R.style.window_ri_ro_style
                      else -> R.style.window_ri_lo_style
                  }
              )
          }


            if (mWidthFullScreen){
                controller.window.decorView.setPadding(0,0,0,0)
                val param = controller.window.attributes
                param.width = WindowManager.LayoutParams.MATCH_PARENT
                if (!mHeightFullScreen){
                    param.height = WindowManager.LayoutParams.WRAP_CONTENT
                }else{
                    param.height = WindowManager.LayoutParams.MATCH_PARENT
                }
                controller.window.attributes=param
            }

            controller.window.setGravity(mRootGravity)

            controller.dialog.setContentView(mView!!)

        }

    }
}