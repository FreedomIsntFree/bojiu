package com.zafir.bojiu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.zafir.bojiu.R
import com.zafir.bojiu.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var mModel: HomeViewModel
    private lateinit var mAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mModel = ViewModelProvider(this as ViewModelStoreOwner)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        mAdapter = PageAdapter(this)
        binding.viewPager.adapter = mAdapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val menuItem = binding.navigation.menu.getItem(position)
                menuItem.isChecked = true
                mModel.pageIndex.postValue(position)
            }
        })

        binding.navigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_today -> binding.viewPager.setCurrentItem(0, false)
                R.id.navigation_subscription -> binding.viewPager.setCurrentItem(1, false)
                R.id.navigation_calendar -> binding.viewPager.setCurrentItem(2, false)
                R.id.navigation_mine -> binding.viewPager.setCurrentItem(3, false)
            }
            true
        }
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.offscreenPageLimit = binding.navigation.menu.size() - 1
    }

}