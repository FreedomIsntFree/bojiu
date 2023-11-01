package com.zafir.bojiu.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val pageIndex: MutableLiveData<Int> = MutableLiveData(-1)
}