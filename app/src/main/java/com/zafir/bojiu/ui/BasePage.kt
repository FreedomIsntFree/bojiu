package com.zafir.bojiu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

abstract class BasePage : Fragment() {
    companion object {
        @JvmStatic
        fun setPageIndex(index: Int, fragment: Fragment) {
            val bundle = Bundle()
            bundle.putInt("index", index)
            fragment.arguments = bundle
        }

        @JvmStatic
        fun getPageIndex(fragment: Fragment): Int {
            return fragment.arguments?.getInt("index", -1) ?: -1
        }
    }

    protected lateinit var mModel: HomeViewModel
    private val mPageChanged = Observer<Int> { onPageChanged(it) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mModel = ViewModelProvider((context as ViewModelStoreOwner))[HomeViewModel::class.java]
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mModel.pageIndex.observe(viewLifecycleOwner, mPageChanged)
    }

    override fun onDestroyView() {
        mModel.pageIndex.removeObserver { mPageChanged }
        super.onDestroyView()
    }

    protected open fun onPageChanged(index: Int) {}

}