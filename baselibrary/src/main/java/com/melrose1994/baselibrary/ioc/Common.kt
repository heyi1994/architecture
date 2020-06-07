package com.melrose1994.baselibrary.ioc

import android.app.Activity
import android.view.View

/**
 * @author Melrose
 * @since 1.0.0
 */



fun findById(viewId:Int,activity:Activity) = activity.findViewById<View>(viewId)