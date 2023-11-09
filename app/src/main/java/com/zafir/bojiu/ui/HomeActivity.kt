package com.zafir.bojiu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.zafir.bojiu.R
import com.zafir.bojiu.databinding.ActivityHomeBinding
import com.zafir.bojiu.ui.PageAdapter.Companion.FRAGMENT_ALMANAC
import com.zafir.bojiu.ui.PageAdapter.Companion.FRAGMENT_MINE
import com.zafir.bojiu.ui.PageAdapter.Companion.FRAGMENT_TODAY
import com.zafir.bojiu.ui.PageAdapter.Companion.FRAGMENT_WEATHER

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var mModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mModel = ViewModelProvider(this as ViewModelStoreOwner)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.viewPager.apply {
            adapter = PageAdapter(supportFragmentManager)
            setScanScroll(false)
            offscreenPageLimit = binding.navigation.menu.size() - 1
        }

        binding.navigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_today -> binding.viewPager.setCurrentItem(FRAGMENT_TODAY, false)
                R.id.navigation_weather -> binding.viewPager.setCurrentItem(FRAGMENT_WEATHER, false)
                R.id.navigation_tool -> binding.viewPager.setCurrentItem(FRAGMENT_ALMANAC, false)
                R.id.navigation_mine -> binding.viewPager.setCurrentItem(FRAGMENT_MINE, false)
            }
            true
        }

    }

}