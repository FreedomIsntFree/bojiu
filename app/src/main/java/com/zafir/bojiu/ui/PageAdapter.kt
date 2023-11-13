package com.zafir.bojiu.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.zafir.bojiu.ui.mine.MineFragment
import com.zafir.bojiu.ui.today.TodayFragment2
import com.zafir.bojiu.ui.tools.ToolFragment
import com.zafir.bojiu.ui.weather.WeatherFragment

class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        const val FRAGMENT_TODAY = 0
        const val FRAGMENT_WEATHER = 1
        const val FRAGMENT_ALMANAC = 2
        const val FRAGMENT_MINE = 3
    }

    override fun getCount(): Int {
        return FRAGMENT_MINE + 1
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            FRAGMENT_TODAY -> TodayFragment2()
            FRAGMENT_WEATHER -> WeatherFragment()
            FRAGMENT_ALMANAC -> ToolFragment()
            else -> MineFragment()
        }
    }

}