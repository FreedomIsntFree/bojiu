package com.zafir.bojiu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentMineBinding
import com.zafir.bojiu.databinding.FragmentTodayBinding

class MinePage : Fragment() {
    companion object {
        val TAG: String = MinePage::class.java.simpleName
    }

    private lateinit var mBinding: FragmentMineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMineBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}