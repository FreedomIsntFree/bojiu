package com.zafir.bojiu

import android.app.Application
import android.content.Context
import com.zafir.bojiu.net.HttpLoader

class BoJiuApplication : Application() {

    private var mIsRunInDev = false


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        mIsRunInDev = BuildConfig.IS_DEV
    }

    override fun onCreate() {
        super.onCreate()
        AppContext.init(this, resources.getString(R.string.app_name))
        HttpLoader.doInit(mIsRunInDev)
    }

}