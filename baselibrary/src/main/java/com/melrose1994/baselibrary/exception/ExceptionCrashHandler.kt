package com.melrose1994.baselibrary.exception

import android.content.Context
import com.melrose1994.baselibrary.BuildConfig
import com.orhanobut.logger.Logger

/**
 * #### 单例异常捕捉 ;
 * @author Melrose
 * @since 1.0.0
 */
class ExceptionCrashHandler private constructor(): Thread.UncaughtExceptionHandler {

    companion object{
        val instance:Lazy<ExceptionCrashHandler> = lazy {
            ExceptionCrashHandler()
        }
    }

    /**
     * 让系统默认处理 ；
     */
    private var mUncaughtExceptionHandler: Thread.UncaughtExceptionHandler?=null

    fun init(){
        Thread.currentThread().setUncaughtExceptionHandler(this)
        mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
    }


    override fun uncaughtException(t: Thread, e: Throwable) {
        Logger.e(e,"get some error!")
        //todo 写入文件 ;
        mUncaughtExceptionHandler?.uncaughtException(t,e)
    }
}