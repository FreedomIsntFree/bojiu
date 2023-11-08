package com.zafir.bojiu.ui.today.plana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodaySubBinding

class SubFragment : Fragment() {
    companion object {
        val TAG: String = SubFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentTodaySubBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTodaySubBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}