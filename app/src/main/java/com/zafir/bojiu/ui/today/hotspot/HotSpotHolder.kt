package com.zafir.bojiu.ui.today.hotspot

import android.util.Log
import android.view.View
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.ListItemHotSpotBinding
import com.zafir.bojiu.model.HotSpotTab
import com.zafir.bojiu.utils.TimeUtils

class HotSpotHolder(private val binding: ListItemHotSpotBinding) : AppViewHolder(binding.root) {

    var nameAndCreateTime: String = ""
    override fun initView(root: View, data: BunItem) {
        if (data !is HotSpotTab) {
            return
        }
        Log.d("wuzhenB", "nameAndCreateTime: " + data.tabName)
        nameAndCreateTime = data.tabName + "    " + TimeUtils.getDateFromTimeMillis(System.currentTimeMillis()).toString()
        binding.title.text = data.tabName
    }

    override fun onItemClick(root: View) {

    }

}