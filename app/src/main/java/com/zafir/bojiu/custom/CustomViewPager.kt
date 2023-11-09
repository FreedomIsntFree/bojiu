package com.zafir.bojiu.custom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


class CustomViewPager : ViewPager {
    private var isCanScroll = true

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    fun setScanScroll(isCanScroll: Boolean) {
        this.isCanScroll = isCanScroll
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (isCanScroll)
            super.onTouchEvent(ev)
        else
            false
    }

    override fun onInterceptTouchEvent(arg0: MotionEvent): Boolean {
        return if (isCanScroll)
            super.onInterceptTouchEvent(arg0)
        else
            false
    }
}

