package com.zafir.bojiu.model

import com.zafir.bojiu.base.interfaces.BunItem

class HotSpotContent(var title: String) : BunItem

class HotSpotTab(
    var tabName: String,
    var tab: String,
) : BunItem {

    override fun toString(): String {
        return "HotSpotTab(tabName='$tabName', tab='$tab')"
    }

}