package com.zafir.bojiu.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zafir.bojiu.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {
    companion object {
        val TAG: String = WeatherFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentWeatherBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("wuzhenB", TAG + "  onResume: ")
    }


}