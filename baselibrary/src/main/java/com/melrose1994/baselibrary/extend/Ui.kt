package com.melrose1994.baselibrary.extend

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import splitties.views.dsl.core.Ui

/**
 * @author Melrose
 * @since 1.0.0
 */



fun Ui.getColor(@ColorRes resId:Int) = ctx.resources.getColor(resId)

fun Ui.getString(@StringRes resId: Int) = ctx.getString(resId)