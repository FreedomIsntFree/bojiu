package com.zafir.bojiu.ui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


private const val TODAY_PAGE = 0
private const val SUBSCRIPTION_PAGE = 1
private const val CALENDAR_PAGE = 2
private const val MINE_PAGE = 3
private const val PAGE_COUNT = 4

private const val TODAY_PAGE_ID = 99L
private const val CALENDAR_PAGE_ID = 100L
private const val SUBSCRIPTION_PAGE_ID = 101L
private const val MINE_PAGE_ID = 102L

/*
java.lang.IllegalStateException: Design assumption violated
重写FragmentStateAdapter的 getItemId，必须重写containsItem方法，否则就报上边的异常。
*/

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val TAG: String = "wuzhenB"
    override fun getItemCount(): Int = PAGE_COUNT
    override fun getItemId(position: Int): Long {
        Log.d(TAG, "getItemId: $position")
        val retValue = when (position) {
            TODAY_PAGE -> TODAY_PAGE_ID
            SUBSCRIPTION_PAGE -> SUBSCRIPTION_PAGE_ID
            CALENDAR_PAGE -> CALENDAR_PAGE_ID
            MINE_PAGE -> MINE_PAGE_ID
            else -> super.getItemId(position)
        }
        return retValue
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in TODAY_PAGE_ID..MINE_PAGE_ID
    }

    override fun createFragment(position: Int): Fragment {
        val retFragment = when (position) {
            TODAY_PAGE -> TodayPage()
            SUBSCRIPTION_PAGE -> WeatherPage()
            CALENDAR_PAGE -> AlmanacPage()
            MINE_PAGE -> MinePage()
            else -> Fragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }
}