package com.zafir.bojiu.ui.today.plana

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TodayPagerAdapter(
    fm: FragmentManager,
    private var infos: List<Fragment>,
    private var titles: List<String>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return infos.size
    }

    override fun getItem(position: Int): Fragment {
        return infos[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}