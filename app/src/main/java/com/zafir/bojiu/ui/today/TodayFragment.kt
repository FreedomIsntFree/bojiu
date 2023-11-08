package com.zafir.bojiu.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayBinding
import com.zafir.bojiu.model.TodayPageItem

class TodayFragment : Fragment() {
    companion object {
        val TAG: String = TodayFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayBinding
    private lateinit var mAdapter: TodayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayBinding.inflate(inflater, container, false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        mAdapter = TodayAdapter()
        val l = if (true) {
            listOf(TodayPageItem(C_PAGE, "日历"), TodayPageItem(S_PAGE, "订阅"), TodayPageItem(H_PAGE, "热点"))
        } else {
            listOf(TodayPageItem(C_PAGE, "日历"), TodayPageItem(S_PAGE, "订阅"))
        }

//        mBinding.pageRoot.apply {
//            adapter = mAdapter
//            isUserInputEnabled = false
//            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//
//                }
//            })
//        }
//        TabLayoutMediator(mBinding.tabCard, mBinding.pageRoot) { tab, pos ->
//            tab.text = l[pos].name
//        }.attach()

        mAdapter.updateDataList(l)
    }

}