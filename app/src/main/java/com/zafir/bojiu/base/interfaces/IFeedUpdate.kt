package com.zafir.bojiu.base.interfaces

interface IFeedUpdate {
    fun insert(position: Int, items: List<BunItem>)
    fun update(position: Int, bunItem: BunItem)
    fun update(position: Int)
    fun remove(position: Int)
}