package com.zafir.bojiu.ui.today.hotspot

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.zafir.bojiu.databinding.FragmentTodayHotBinding
import com.zafir.bojiu.model.HotSpotTab

class HotSpotFragment : Fragment() {
    companion object {
        val TAG: String = HotSpotFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayHotBinding
    private lateinit var mAdapter: HotSpotAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayHotBinding.inflate(inflater, container, false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        Log.w("wuzhenB", "HotFragment  initView: ")
        mAdapter = HotSpotAdapter()
        val hotSpotTabList: MutableList<HotSpotTab> = arrayListOf(
            HotSpotTab("推荐", "1"),
            HotSpotTab("体育", "1"),
            HotSpotTab("财经", "1"),
            HotSpotTab("娱乐", "1"),
            HotSpotTab("军事", "1"),
            HotSpotTab("科技", "1"),
            HotSpotTab("国内", "1"),
            HotSpotTab("国际", "1"),
            HotSpotTab("明星", "1"),
            HotSpotTab("互联网", "1"),
            HotSpotTab("杂乱无章", "1")
        )
        for (title in hotSpotTabList) {
            mBinding.tabCard.addTab(mBinding.tabCard.newTab().setText(title.tabName))
        }

        mBinding.viewPager.apply {
            adapter = mAdapter
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    Log.d("wuzhenB", "onPageSelected: "+position)
                }
            })
        }

        TabLayoutMediator(mBinding.tabCard, mBinding.viewPager) { tab, pos ->
            tab.text = hotSpotTabList[pos].tabName
        }.attach()

        mAdapter.updateDataList(hotSpotTabList)
    }

    override fun onResume() {
        super.onResume()
        Log.d("wuzhenB", "HotFragment   onResume: ")
    }


}