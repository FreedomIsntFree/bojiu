package com.zafir.bojiu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zafir.bojiu.ui.HomeActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        jumpToHome()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun jumpToHome() {
        GlobalScope.launch {
            delay(500)
            this@SplashActivity.apply {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }

        }
    }
}