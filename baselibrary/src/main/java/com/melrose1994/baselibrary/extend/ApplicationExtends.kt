package com.melrose1994.baselibrary.extend

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process

/**
 * @author Melrose
 * @since 1.0.0
 */


fun Application.isMainProcess(): Boolean {
        val pid = Process.myPid()
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (appProcess in activityManager.runningAppProcesses) {
            if (appProcess.pid == pid) {
                return applicationInfo.packageName == appProcess.processName
            }
        }
        return false
}



