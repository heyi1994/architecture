package com.melrose1994.baselibrary.dialog.alert

import android.content.Context
import android.view.View
import androidx.cardview.widget.CardView
import com.melrose1994.baselibrary.R
import com.melrose1994.baselibrary.extend.getColor
import splitties.dimensions.dip
import splitties.dimensions.dp
import splitties.views.dsl.core.*

/**
 * @author Melrose
 * @since 1.0.0
 */
class AlertUi(override val ctx: Context) :Ui{


    override val root: View
        get() = view(::CardView){
            cardElevation = dp(4)
            maxCardElevation = dp(4)
            preventCornerOverlap = true
            radius  = dp(8)
            setCardBackgroundColor(getColor(R.color.md_white))

            layoutParams = lParams(matchParent) {
                startMargin = dip(10)
                endMargin = dip(10)
            }
        }

}