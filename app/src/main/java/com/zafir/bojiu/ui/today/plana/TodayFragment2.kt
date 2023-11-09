package com.zafir.bojiu.ui.today.plana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.R
import com.zafir.bojiu.databinding.FragmentToday2Binding

class TodayFragment2 : Fragment() {
    companion object {
        val TAG: String = TodayFragment2::class.java.simpleName
    }

    private lateinit var mBinding: FragmentToday2Binding
    private lateinit var mAdapter: TodayPagerAdapter
    private val titles: MutableList<String> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentToday2Binding.inflate(inflater, container, false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        titles.clear()
        titles.add(getString(R.string.calendar))
        titles.add(getString(R.string.subscription))
        titles.add(getString(R.string.hotspot))

        for (title in titles) {
            mBinding.tabCard.addTab(mBinding.tabCard.newTab().setText(title))
        }

        mAdapter = activity?.supportFragmentManager?.let { TodayPagerAdapter(it, titles) }!!
        mBinding.pageRoot.adapter = mAdapter
        mBinding.pageRoot.setScanScroll(false)
        mBinding.tabCard.setupWithViewPager(mBinding.pageRoot)
    }

}