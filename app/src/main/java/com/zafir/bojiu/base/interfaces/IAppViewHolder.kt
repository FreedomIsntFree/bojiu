package com.zafir.bojiu.base.interfaces

import android.view.View

interface IAppViewHolder<T> {
    fun initView(root: View, data: T)
    fun onItemClick(root: View)
}