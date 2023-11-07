package com.zafir.bojiu.ui

import android.view.View
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem

class EmptyHolder(val view: View) : AppViewHolder(view) {
    override fun initView(root: View, data: BunItem) {
    }

    override fun onItemClick(root: View) {
    }
}