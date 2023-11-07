package com.zafir.bojiu.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zafir.bojiu.R
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.base.interfaces.IAppViewHolder

/**
 * Created by zheng on 2019/3/5.
 */
abstract class AppViewHolder(root: View) : RecyclerView.ViewHolder(root), View.OnClickListener, IAppViewHolder<BunItem> {
    protected var mCoreData: BunItem? = null
    private var mLastClickTime: Long = 0
    private var mPosition = 0

    private fun canFireClick(): Boolean {
        val curTime = System.currentTimeMillis()
        val offset = curTime - mLastClickTime
        if (offset < 1000) {
            return false
        }
        mLastClickTime = curTime
        return true
    }

    fun initHolder(data: BunItem, position: Int) {
        initHolderData(data, position)
        initView(itemView, data)
    }

    private fun initHolderData(data: BunItem, position: Int) {
        mCoreData = data
        mPosition = position
        itemView.setTag(R.id.list_item_postion, position)
        itemView.setOnClickListener(this)
    }

    protected val viewPosition: Int
        get() {
            val tagObj = itemView.getTag(R.id.list_item_postion)
            return if (tagObj is Int) {
                tagObj
            } else -1
        }

    override fun onClick(v: View) {
        if (v === itemView) {
            if (canFireClick()) {
                onItemClick(itemView)
            }
        }
    }
}