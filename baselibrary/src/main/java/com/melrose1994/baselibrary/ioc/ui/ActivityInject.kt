package com.melrose1994.baselibrary.ioc.ui

import android.app.Activity
import com.melrose1994.baselibrary.ioc.MustRunOnIOThread
import com.melrose1994.baselibrary.ioc.findById

/**
 * @author Melrose
 * @since 1.0.0
 */


 fun Activity.inject(){

    injectContentView()

    injectFiled()

    injectEvent()

 }


 private fun Activity.injectContentView(){
     javaClass.getAnnotation(ContentView::class.java)?.let {
         contentView->
         if (contentView.layoutId>0){
             javaClass.getMethod("setContentView",Int::class.java)?.let {
                 it.invoke(this,contentView.layoutId)
             }
         }
     }
 }



private fun Activity.injectFiled(){
    for (filed in javaClass.declaredFields){
        filed.getAnnotation(ViewById::class.java)?.let {
            filed.isAccessible = true
            filed.set(this,findById(it.idRes,this))
        }
    }
}


private fun Activity.injectEvent(){
    for (method in javaClass.declaredMethods){
        method.getAnnotation(OnClick::class.java)?.let {
            method.isAccessible = true
            for (viewId in it.idResArr){
                val view = findById(viewId,this)
                view?.setOnClickListener { method.invoke(this,view) }
            }
        }
    }
}


