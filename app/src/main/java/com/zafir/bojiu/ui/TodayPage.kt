package com.zafir.bojiu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayBinding

class TodayPage : Fragment() {
    companion object {
        val TAG: String = TodayPage::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayBinding.inflate(inflater, container, false)
        return mBinding.root
    }

}