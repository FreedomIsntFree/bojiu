package com.zafir.bojiu.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

object HttpLoader {

    private val mInterceptors: ArrayList<Interceptor> = arrayListOf()
    private var mIsRunInDev = false
    private var mOkHttpClient: OkHttpClient? = null

    fun doInit(isDev: Boolean, vararg headerInterceptor: Interceptor) {
        mInterceptors.addAll(headerInterceptor)
        mIsRunInDev = isDev
        initOkHttpClient()
    }

    private fun initOkHttpClient() {
        val builder = OkHttpClient.Builder()
        //在OkHttp等网络库中，retryOnConnectionFailure 也是一个属性变量，可以在初始化的时候设置，用于控制是否进行重连。如果设置为false，那么当连接失败时，就不会进行重连
        //followRedirects 是一个选项，通常在处理HTTP请求时使用，它决定了当发生HTTP重定向时是否自动跟随重定向。
        //followSslRedirects 是一个选项，通常在处理HTTP请求时使用，它决定了当发生SSL重定向时是否自动跟随重定向。
        builder.readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(true)
            .followSslRedirects(true)

        for (interceptor in mInterceptors) {
            builder.addInterceptor(interceptor)
        }

        if (!mIsRunInDev) builder.proxy(Proxy.NO_PROXY)//不使用代理

        mOkHttpClient = addLogging(builder).build()
    }

    private fun addLogging(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        if (!mIsRunInDev) {
            return builder
        }

        val loggingInterceptor = HttpLoggingInterceptor { message: String ->
            Log.d("http", message)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
        return builder
    }

    fun <T> addHttpService(url: String, cls: Class<T>): T {
        return createHttpRequest(url).create(cls)
    }

    private fun createHttpRequest(url: String): Retrofit {
        return Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient!!)
            .build()
    }

}