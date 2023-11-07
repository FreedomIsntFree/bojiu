package com.zafir.bojiu.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.zafir.bojiu.base.interfaces.BunItem
import com.zafir.bojiu.base.interfaces.IFeedUpdate

abstract class AppRecyclerAdapter : RecyclerView.Adapter<AppViewHolder>(), IFeedUpdate {
    protected val datas: MutableList<BunItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataList(items: List<BunItem>) {
        val isUpdate = datas.isNotEmpty()
        datas.clear()
        items.forEach { datas.add(it) }
        if (isUpdate) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(0, datas.size)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItemViewType(datas[position])
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.initHolder(datas[position], position)
    }

    override fun getItemCount() = datas.size
    override fun insert(position: Int, items: List<BunItem>) {
        datas.addAll(position, items)
        notifyItemRangeInserted(position, items.size)
    }

    fun getData(): MutableList<BunItem> {
        return datas
    }

    override fun update(position: Int, bunItem: BunItem) {
        datas[position] = bunItem
        notifyItemChanged(position)
    }

    override fun update(position: Int) {
        notifyItemChanged(position)
    }

    override fun remove(position: Int) {
        datas.removeAt(position)
        notifyItemRemoved(position)
    }

    abstract fun getItemViewType(item: BunItem): Int
}