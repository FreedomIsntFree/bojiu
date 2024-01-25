package com.zafir.bojiu.net.request

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.zafir.bojiu.interfaces.IRemoteData
import com.zafir.bojiu.net.listener.HttpListener
import com.zafir.bojiu.net.observe.NetWorkObserver
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class NetRequest : ViewModel() {

    open fun <T : IRemoteData> doRequest(observable: Observable<T>?, callback: HttpListener<T>?, lifecycle: Lifecycle): Boolean {
        observable?.run {
            this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(NetWorkObserver(callback, lifecycle))
            return true
        }
        return false
    }

}