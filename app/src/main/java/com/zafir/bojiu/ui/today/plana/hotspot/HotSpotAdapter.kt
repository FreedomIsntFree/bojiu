package com.zafir.bojiu.ui.today.plana.hotspot

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zafir.bojiu.base.AppRecyclerAdapter
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.ListItemHotSpotBinding
import com.zafir.bojiu.model.HotSpotTab
import com.zafir.bojiu.ui.EmptyHolder

class HotSpotAdapter : AppRecyclerAdapter() {

    override fun getItemViewType(item: BunItem): Int {
        if (item is HotSpotTab) {
            return datas.indexOf(item)
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cerHolder = if (0 <= viewType && viewType < datas.size) {
            HotSpotHolder(ListItemHotSpotBinding.inflate(inflater, parent, false))
        } else {
            EmptyHolder(View(parent.context).apply {
                layoutParams = ActionBar.LayoutParams(
                    ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT
                )
            })
        }
        return cerHolder
    }


}