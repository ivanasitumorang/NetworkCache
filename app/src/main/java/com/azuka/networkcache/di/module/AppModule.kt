package com.azuka.networkcache.di.module

import com.azuka.base.external.AppCoroutineContextProvider
import com.azuka.base.external.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider = AppCoroutineContextProvider()
}