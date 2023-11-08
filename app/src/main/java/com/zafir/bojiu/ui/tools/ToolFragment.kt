package com.zafir.bojiu.ui.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentToolBinding

class ToolFragment : Fragment() {
    companion object {
        val TAG: String = ToolFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentToolBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentToolBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}