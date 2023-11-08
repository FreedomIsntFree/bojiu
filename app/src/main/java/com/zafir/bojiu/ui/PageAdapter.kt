package com.zafir.bojiu.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


private const val TODAY_PAGE = 0
private const val SUBSCRIPTION_PAGE = 1
private const val CALENDAR_PAGE = 2
private const val MINE_PAGE = 3
private const val PAGE_COUNT = 4

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = PAGE_COUNT
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in TODAY_PAGE..MINE_PAGE
    }

    override fun createFragment(position: Int): Fragment {
        val retFragment = when (position) {
            TODAY_PAGE -> TodayPage2()
            SUBSCRIPTION_PAGE -> WeatherPage()
            CALENDAR_PAGE -> AlmanacPage()
            MINE_PAGE -> MinePage()
            else -> Fragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }
}