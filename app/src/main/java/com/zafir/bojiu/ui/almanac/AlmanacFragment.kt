package com.zafir.bojiu.ui.almanac

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentAlmanacBinding

class AlmanacFragment : Fragment() {
    companion object {
        val TAG: String = AlmanacFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentAlmanacBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAlmanacBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}