package com.zafir.bojiu.interfaces

interface IRemoteData : NoProguard, IRequestCell {
    fun getOperationCode(): Int
    fun getErrorCode(): Int
    fun getErrorMessage(): String
    fun dataIsValid(): Boolean
    fun readyData(): Boolean
}