package com.melrose1994.customui.drag

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.customview.widget.ViewDragHelper

/**
 * #### 子控件可拖动 ;
 * @author Melrose
 * @since 1.0.0
 */
class DragFrameLayout :FrameLayout{
    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet):super(context,attrs)
    constructor(context: Context,attrs: AttributeSet,def:Int):super(context,attrs,def)

    private val mViewDragHelper: ViewDragHelper

    init {
        mViewDragHelper = ViewDragHelper.create(this,1f,object :ViewDragHelper.Callback(){
            /**
             *  默认所有控件皆可拖动 ;
             */
            override fun tryCaptureView(child: View, pointerId: Int) = true

            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                return  left
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                return top
            }

            override fun getViewHorizontalDragRange(child: View): Int {
                return measuredWidth - child.measuredWidth
            }

            override fun getViewVerticalDragRange(child: View): Int {
                return  measuredHeight - child.measuredHeight
            }
        })

        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT)
    }



    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return mViewDragHelper.shouldInterceptTouchEvent(ev!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let { mViewDragHelper.processTouchEvent(it) }
        return true
    }

    override fun computeScroll() {
        if (mViewDragHelper.continueSettling(true)){ invalidate() }
    }

}