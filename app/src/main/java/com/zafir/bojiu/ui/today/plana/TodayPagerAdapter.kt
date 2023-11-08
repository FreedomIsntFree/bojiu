package com.zafir.bojiu.ui.today.plana

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TodayPagerAdapter(fm: FragmentManager, private var titles: List<String>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val TODAY_CAL = 0
        private const val TODAY_SUB = 1
        private const val TODAY_HOTSPOT = 2
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            TODAY_CAL -> CalFragment()
            TODAY_SUB -> SubFragment()
            else -> HotFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}