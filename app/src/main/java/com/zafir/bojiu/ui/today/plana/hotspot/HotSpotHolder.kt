package com.zafir.bojiu.ui.today.plana.hotspot

import android.view.View
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.ListItemHotSpotBinding
import com.zafir.bojiu.model.HotSpotContent

class HotSpotHolder(private val binding: ListItemHotSpotBinding) : AppViewHolder(binding.root) {

    override fun initView(root: View, data: BunItem) {
        if (data !is HotSpotContent) {
            return
        }
        binding.title.text = data.title
    }

    override fun onItemClick(root: View) {

    }

}