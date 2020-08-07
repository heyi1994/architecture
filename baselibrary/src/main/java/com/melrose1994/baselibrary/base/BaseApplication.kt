package com.melrose1994.baselibrary.base

import android.app.Application
import com.melrose1994.baselibrary.BuildConfig
import com.melrose1994.baselibrary.dialog.BaseDialog
import com.melrose1994.baselibrary.exception.ExceptionCrashHandler
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * @author Melrose
 * @since 1.0.0
 */
class BaseApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        ExceptionCrashHandler.instance.value.init()
        Logger.addLogAdapter(AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder().apply {
                tag(BuildConfig.TAG)
            }.build()
        ))


    }
}