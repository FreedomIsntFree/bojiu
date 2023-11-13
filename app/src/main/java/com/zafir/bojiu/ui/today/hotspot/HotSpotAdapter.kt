package com.zafir.bojiu.ui.today.hotspot

import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zafir.bojiu.base.AppRecyclerAdapter
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.ListItemHotSpotBinding
import com.zafir.bojiu.model.HotSpotTab

class HotSpotAdapter : AppRecyclerAdapter() {
    private val sparseArray: SparseArray<AppViewHolder> = SparseArray()

    override fun getItemViewType(item: BunItem): Int {
        if (item is HotSpotTab) {
            return datas.indexOf(item)
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        Log.w("wuzhenB", "sparseArray set : " + viewType)
        sparseArray[viewType] = HotSpotHolder(ListItemHotSpotBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return sparseArray[viewType]
    }

    fun getHolderByHotSpotTab(index: Int): AppViewHolder? {
        return sparseArray[index]
    }

}