package com.zafir.bojiu

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class BoJiuApplication : Application() {




    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
       AppContext.init(this,  resources.getString(R.string.app_name))

    }

}