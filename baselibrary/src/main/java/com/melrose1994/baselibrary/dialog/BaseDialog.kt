package com.melrose1994.baselibrary.dialog

import android.app.Dialog
import android.content.Context
import android.util.SparseArray
import android.view.Gravity
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.melrose1994.baselibrary.R
import com.melrose1994.baselibrary.base.VoidCallback
import com.melrose1994.baselibrary.bean.AnimGravity
import splitties.views.dsl.core.Ui
import java.lang.IllegalArgumentException

/**
 * @property themeResId style id ;
 * @author Melrose
 * @since 1.0.0
 */
class BaseDialog(context: Context, @StyleRes val themeResId:Int = R.style.DialogStyle): Dialog(context,themeResId) {

     val mController:BaseController


    init {
        mController = BaseController(this,window!!)
    }



     class Builder(private val context: Context){


         private val P:BaseController.BaseParams

         init {
             P = BaseController.BaseParams(context)
         }


         /**
          * 创建Dialog ;
          * @throws IllegalArgumentException 如果没有设置[View]或者自定义动画没设置[BaseController.BaseParams.mAnimStyleRes]时则会抛出该异常;
          */
         @Throws(IllegalArgumentException::class)
         fun create() :BaseDialog{
             val dialog = BaseDialog(context, if (P.mHasMask)R.style.DialogStyle else R.style.DialogStyle_No_Frame)
             P.apply(dialog.mController)
             return  dialog
         }


         /**
          * 设置布局与[Ui.root]一起使用；
          */
         fun setContentView(view: View) :Builder{
             P.mView = view
             return this
         }


         /**
          * 点击是否可取消；
          */
         fun setCancelable(cancelable: Boolean) :Builder{
             P.mCancelable = cancelable
             return this
         }



         fun setOnDismissCallback(callback: VoidCallback) :Builder{
             P.mDismissCallback = callback
             return this
         }

         fun setOnCancelableCallback(callback: VoidCallback) :Builder{
             P.mCancelableCallback = callback
             return this
         }


         /**
          * 开启动画,默认动画下进下出 ;
          * @param animGravity Dialog进入退出动画类型,详细查看[AnimGravity] ;
          * @param animStyleRes 自定义动画资源ID,当[animGravity]为[AnimGravity.CUSTOM]时请务必设置[animStyleRes] ;
          * @see AnimGravity
          */
         fun applyAnimation(animGravity: AnimGravity = AnimGravity.BI_BO,
                       @StyleRes animStyleRes:Int = 0) :Builder{
             P.mAnimGravity = animGravity
             P.mAnimStyleRes = animStyleRes
             return this
         }


         /**
          * 设置Dialog的Root View是否填充屏幕 ;
          * @param widthFullScreen Root View宽度填充全屏 ;
          * @param heightFullScreen Root View高度填充全屏 ;
          */
         fun applyRootViewSize(widthFullScreen:Boolean = false,
                               heightFullScreen:Boolean = false) :Builder{
             P.mWidthFullScreen = widthFullScreen
             P.mHeightFullScreen = heightFullScreen
             return this
         }

         /**
          * 设置整个Root View在Window中的位置
          * @param gravity Root View在Window中的位置 ;
          * @see Gravity
          */
         fun applyRootViewGravity(gravity: Int = Gravity.CENTER):Builder{
             P.mRootGravity = gravity
             return this
         }
     }
}