package com.zafir.bojiu.net.listener

import com.zafir.bojiu.interfaces.IRequestCell

interface HttpListener<T> {
    fun onLoading(cell: IRequestCell?)
    fun onSuccess(Data: T, cell: IRequestCell?)
    fun onFailed(cell: IRequestCell?, code: Int, opCode: Int, msg: String?)
    fun onLastPage(cell: IRequestCell?)
    fun onComplete()
}

enum class HttpError(val code: Int) {
    HTTP_ERROR(-1), DATA_ERROR(-20), OTHER_ERROR(-2)
}