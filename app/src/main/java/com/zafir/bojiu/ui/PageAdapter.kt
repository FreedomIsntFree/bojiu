package com.zafir.bojiu.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zafir.bojiu.ui.almanac.AlmanacFragment
import com.zafir.bojiu.ui.mine.MineFragment
import com.zafir.bojiu.ui.today.TodayFragment2
import com.zafir.bojiu.ui.weather.WeatherFragment


private const val TODAY_PAGE = 0
private const val SUBSCRIPTION_PAGE = 1
private const val CALENDAR_PAGE = 2
private const val MINE_PAGE = 3

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = MINE_PAGE + 1
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in TODAY_PAGE..MINE_PAGE
    }

    override fun createFragment(position: Int): Fragment {
        val retFragment = when (position) {
            TODAY_PAGE -> TodayFragment2()
            SUBSCRIPTION_PAGE -> WeatherFragment()
            CALENDAR_PAGE -> AlmanacFragment()
            MINE_PAGE -> MineFragment()
            else -> Fragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }
}