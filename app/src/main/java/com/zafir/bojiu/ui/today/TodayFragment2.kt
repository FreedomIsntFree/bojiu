package com.zafir.bojiu.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayBinding

class TodayFragment2 : Fragment() {
    companion object {
        val TAG: String = TodayFragment2::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayBinding
    private lateinit var mAdapter: TodayPagerAdapter
    private val titles: MutableList<String> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayBinding.inflate(inflater, container, false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        titles.clear()
        titles.add("日历")
        titles.add("订阅")
        titles.add("热点")

        for (title in titles) {
            mBinding.tabCard.addTab(mBinding.tabCard.newTab().setText(title))
        }
        val fragments: MutableList<Fragment> = arrayListOf()
        fragments.add(CalFragment())
        fragments.add(SubFragment())
        fragments.add(HotFragment())

        mAdapter = activity?.supportFragmentManager?.let { TodayPagerAdapter(it, fragments, titles) }!!
        mBinding.pageRoot.adapter = mAdapter
        mBinding.tabCard.setupWithViewPager(mBinding.pageRoot)
    }

}