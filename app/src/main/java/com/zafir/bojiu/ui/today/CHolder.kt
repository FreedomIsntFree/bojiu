package com.zafir.bojiu.ui.today

import android.view.View
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.LayoutTodayPageBinding
import com.zafir.bojiu.model.TodayPageItem

class CHolder( private val binding: LayoutTodayPageBinding) : AppViewHolder(binding.root) {

    override fun initView(root: View, data: BunItem) {
        if (data !is TodayPageItem) {
            return
        }
        binding.pageName.text = data.name
    }

    override fun onItemClick(root: View) {

    }

}