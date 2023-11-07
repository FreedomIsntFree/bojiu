package com.zafir.bojiu.ui.today

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zafir.bojiu.base.AppRecyclerAdapter
import com.zafir.bojiu.base.AppViewHolder
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.databinding.LayoutTodayPageBinding
import com.zafir.bojiu.model.TodayPageItem
import com.zafir.bojiu.ui.EmptyHolder

const val C_PAGE = 0
const val S_PAGE = 1
const val H_PAGE = 2
private const val PAGE_COUNT = 3

class TodayAdapter : AppRecyclerAdapter() {

    override fun getItemViewType(item: BunItem): Int {
        if (item is TodayPageItem) {
            return datas.indexOf(item)
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cerHolder = if (0 <= viewType && viewType < datas.size) {
            CHolder(LayoutTodayPageBinding.inflate(inflater, parent, false))
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