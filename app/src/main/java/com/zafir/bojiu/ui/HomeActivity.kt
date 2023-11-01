package com.zafir.bojiu.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zafir.bojiu.R
import com.zafir.bojiu.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var mModel: HomeViewModel
    private lateinit var mAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mModel = ViewModelProvider(this as ViewModelStoreOwner)[HomeViewModel::class.java]
        binding = ActivityHomeBinding.inflate(layoutInflater, ActivityHomeBinding.inflate(layoutInflater).root, false)
        initViewPage(binding.pageRoot, binding.navigation)
        initNavigationView(binding.pageRoot, binding.navigation)
        binding.pageRoot.isUserInputEnabled = false
        binding.pageRoot.offscreenPageLimit = binding.navigation.menu.size() - 1
    }

    private fun initViewPage(pager: ViewPager2, navigationView: BottomNavigationView) {
        mAdapter = PageAdapter(this)
        pager.adapter = mAdapter
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val menuItem = navigationView.menu.getItem(position)
                menuItem.isChecked = true
                mModel.pageIndex.postValue(position)
            }
        })
    }


    private fun initNavigationView(pager: ViewPager2, navigationView: BottomNavigationView) {
        navigationView.setOnItemSelectedListener { menuItem ->
            Log.e("wuzhenB", "initNavigationView: ${menuItem.itemId}" )
            when (menuItem.itemId) {
                R.id.navigation_today -> {
                    setCurrentPage(pager, 0)
                }
                R.id.navigation_subscription -> {
                    setCurrentPage(pager, 1)
                }
                R.id.navigation_calendar -> {
                    setCurrentPage(pager, 2)
                }
                R.id.navigation_mine -> {
                    setCurrentPage(pager, 3)
                }
            }
            true
        }
    }

    private fun setCurrentPage(pager: ViewPager2, item: Int) {
        pager.setCurrentItem(item, false)
    }
}