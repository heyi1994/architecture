package com.melrose1994.baselibrary.ioc.ui

import androidx.annotation.LayoutRes

/**
 * @author Melrose
 * @since 1.0.0
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ContentView(@LayoutRes val layoutId:Int)