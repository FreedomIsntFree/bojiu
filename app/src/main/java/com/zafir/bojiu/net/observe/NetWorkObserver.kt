package com.zafir.bojiu.net.observe

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.zafir.bojiu.interfaces.IRemoteData
import com.zafir.bojiu.net.listener.HttpError
import com.zafir.bojiu.net.listener.HttpListener
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

class NetWorkObserver<T : IRemoteData>(private var mCallback: HttpListener<T>?, private var mLifecycle: Lifecycle?) : Observer<T>, DefaultLifecycleObserver {
    private var data: T? = null
    private var httpCall: Disposable? = null

    init {
        initLifecycle()
    }

    private fun initLifecycle() {
        try {
            mLifecycle?.addObserver(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun unInitLifecycle() {
        try {
            mLifecycle?.removeObserver(this)
            mLifecycle = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSubscribe(d: Disposable) {
        doLoading()
        httpCall = d
    }

    override fun onNext(t: T) {
        data = t
        val dataValid = t.dataIsValid()
        val ready: Boolean
        try {
            ready = t.readyData()
        } catch (e: Exception) {
            doFailed(t.getErrorCode(), 0, e.message)
            return
        }

        if (dataValid && ready) {
            doSuccess(t)
        } else {
            doFailed(t.getErrorCode(), t.getOperationCode(), t.getErrorMessage())
        }
    }

    override fun onError(e: Throwable) {
        var errCode: Int
        val errMsg = "网络异常~"
        val msg: String?
        errCode = when (e) {
            is HttpException -> {
                msg = e.response()?.message()
                e.response()?.code() ?: HttpError.HTTP_ERROR.code
            }

            is Exception -> {
                msg = e.message
                HttpError.DATA_ERROR.code
            }

            else -> {
                msg = e.message
                data?.getErrorCode() ?: HttpError.OTHER_ERROR.code
            }
        }
        if (errCode > 0) {
            errCode = -errCode
        }
        doFailed(errCode, 0, msg ?: errMsg)
        onComplete()
    }

    override fun onComplete() {
        mCallback?.onComplete()
        httpCall = null
        unInitLifecycle()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        httpCall?.run {
            if (!isDisposed) {
                dispose()
            }
        }
    }

    private fun checkLifecycle(): Boolean {
        return mLifecycle?.currentState?.isAtLeast(Lifecycle.State.INITIALIZED) ?: true
    }

    private fun doSuccess(t: T?) {
        if (checkLifecycle()) {
            t?.run { mCallback?.onSuccess(t, null) }
        }
    }

    private fun doFailed(code: Int, opCode: Int, msg: String?) {
        if (checkLifecycle()) {
            mCallback?.onFailed(data, code, opCode, msg)
        }
    }

    private fun doLoading() {
        if (checkLifecycle()) {
            mCallback?.onLoading(null)
        }
    }
}