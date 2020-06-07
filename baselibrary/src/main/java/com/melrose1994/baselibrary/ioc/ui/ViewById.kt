package com.melrose1994.baselibrary.ioc.ui

import androidx.annotation.IdRes

/**
 * @author Melrose
 * @since 1.0.0
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class ViewById (@IdRes val idRes:Int)