package com.zafir.bojiu.ui.today

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zafir.bojiu.ui.BasePage
import com.zafir.bojiu.ui.today.hotspot.HotSpotFragment

class TodayPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        private const val TODAY_CAL = 0
        private const val TODAY_SUB = 1
        private const val TODAY_HOTSPOT = 2
    }

    override fun getItemCount(): Int = TODAY_HOTSPOT + 1
    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in TODAY_CAL..TODAY_HOTSPOT
    }

    override fun createFragment(position: Int): Fragment {
        val retFragment = when (position) {
            TODAY_CAL -> CalFragment()
            TODAY_SUB -> SubFragment()
            else -> HotSpotFragment()
        }
        BasePage.setPageIndex(position, retFragment)
        return retFragment
    }
}