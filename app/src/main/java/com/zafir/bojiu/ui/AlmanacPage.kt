package com.zafir.bojiu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentAlmanacBinding

class AlmanacPage : Fragment() {
    companion object {
        val TAG: String = AlmanacPage::class.java.simpleName
    }

    private lateinit var mBinding: FragmentAlmanacBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAlmanacBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}