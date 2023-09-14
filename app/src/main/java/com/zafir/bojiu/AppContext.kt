package com.zafir.bojiu

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object AppContext {
    private var mContext: Context? = null
    private var productName: String = ""

    fun init(context: Context?, productName: String): AppContext {
        mContext = context
        AppContext.productName = productName
        return this
    }

    fun getProductName(): String {
        return productName
    }
}