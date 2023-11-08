package com.zafir.bojiu.ui.today.plana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayHotBinding

class HotFragment : Fragment() {
    companion object {
        val TAG: String = HotFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayHotBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayHotBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}