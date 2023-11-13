package com.zafir.bojiu.ui.today.hotspot

import android.view.View
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.ListItemHotSpotBinding
import com.zafir.bojiu.model.HotSpotTab

class HotSpotHolder(private val binding: ListItemHotSpotBinding) : AppViewHolder(binding.root) {

    override fun initView(root: View, data: BunItem) {
        if (data !is HotSpotTab) {
            return
        }
        binding.title.text = data.tabName
    }

    override fun onItemClick(root: View) {

    }

}