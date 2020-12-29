package com.azuka.base.external

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    fun mainThreadDispatcher(): CoroutineContext
    fun backgroundDispatcher(): CoroutineContext
}
