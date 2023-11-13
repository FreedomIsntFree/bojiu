package com.zafir.bojiu.ui.today

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zafir.bojiu.R
import com.zafir.bojiu.databinding.FragmentToday2Binding

class TodayFragment2 : Fragment() {
    companion object {
        val TAG: String = TodayFragment2::class.java.simpleName
    }

    private lateinit var mBinding: FragmentToday2Binding
    private val titles: MutableList<String> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentToday2Binding.inflate(inflater, container, false)
        initView()
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("wuzhenB", TAG + "  onResume: ")
    }

    private fun initView() {
        titles.clear()
        titles.add(getString(R.string.calendar))
        titles.add(getString(R.string.subscription))
        titles.add(getString(R.string.hotspot))

        for (title in titles) {
            mBinding.tabCard.addTab(mBinding.tabCard.newTab().setText(title))
        }

        mBinding.pageRoot.apply {
            adapter = TodayPagerAdapter(this@TodayFragment2)
            isUserInputEnabled = false
        }

        TabLayoutMediator(mBinding.tabCard, mBinding.pageRoot) { tab, position ->
            tab.text = titles[position]
        }.attach()

//        mBinding.pageRoot.setScanScroll(false)
//        mBinding.tabCard.setupWithViewPager(mBinding.pageRoot)
    }

}