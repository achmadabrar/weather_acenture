package com.achmadabrar.accenturetest.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

abstract class  BaseViewModel<V>: ViewModel() {

    protected val ioScope = CoroutineScope(Dispatchers.Default)

    override fun onCleared() {
        super.onCleared()
        ioScope.coroutineContext.cancel()
    }
}