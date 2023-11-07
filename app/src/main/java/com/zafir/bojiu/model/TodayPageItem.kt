package com.zafir.bojiu.model

import com.zafir.bojiu.base.interfaces.BunItem

//今日限行
class TodayPageItem(
    var type: Int,
    var name: String
) : BunItem {

    override fun toString(): String {
        return "TodayPageItem(type=$type, name='$name')"
    }
}


