package com.zafir.bojiu.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zafir.bojiu.ui.tools.ToolFragment
import com.zafir.bojiu.ui.mine.MineFragment
import com.zafir.bojiu.ui.today.plana.TodayFragment2
import com.zafir.bojiu.ui.today.planb.TodayFragment
import com.zafir.bojiu.ui.weather.WeatherFragment

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    companion object {
        private const val FRAGMENT_TODAY = 0
        private const val FRAGMENT_WEATHER = 1
        private const val FRAGMENT_ALMANAC = 2
        private const val FRAGMENT_MINE = 3
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
            FRAGMENT_TODAY -> TodayFragment2()
            FRAGMENT_WEATHER -> WeatherFragment()
            FRAGMENT_ALMANAC -> ToolFragment()
            FRAGMENT_MINE -> MineFragment()
            else -> Fragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }
}