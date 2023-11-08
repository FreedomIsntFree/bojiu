package com.zafir.bojiu.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayCalBinding

class CalFragment : Fragment() {
    companion object {
        val TAG: String = CalFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodayCalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodayCalBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}