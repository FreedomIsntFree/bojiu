package com.zafir.bojiu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentTodayBinding
import com.zafir.bojiu.databinding.FragmentWeatherBinding

class WeatherPage : Fragment() {
    companion object {
        val TAG: String = WeatherPage::class.java.simpleName
    }

    private lateinit var mBinding: FragmentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentWeatherBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}