package com.zafir.bojiu.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zafir.bojiu.ui.mine.MineFragment
import com.zafir.bojiu.ui.today.TodayFragment
import com.zafir.bojiu.ui.tools.ToolFragment
import com.zafir.bojiu.ui.weather.WeatherFragment

class PageAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    companion object {
        const val FRAGMENT_TODAY = 0
        const val FRAGMENT_WEATHER = 1
        const val FRAGMENT_ALMANAC = 2
        const val FRAGMENT_MINE = 3
    }

    override fun getItemCount(): Int = FRAGMENT_MINE + 1
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in FRAGMENT_TODAY..FRAGMENT_MINE
    }

    override fun createFragment(position: Int): Fragment {
        val retFragment = when (position) {
            FRAGMENT_TODAY -> TodayFragment()
            FRAGMENT_WEATHER -> WeatherFragment()
            FRAGMENT_ALMANAC -> ToolFragment()
            FRAGMENT_MINE -> MineFragment()
            else -> Fragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }

}