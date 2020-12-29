package com.azuka.networkcache.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.azuka.networkcache.base.ViewModelFactory
import com.azuka.networkcache.base.ViewModelKey
import com.azuka.networkcache.domain.usecase.AppUseCase
import com.azuka.networkcache.feature.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import javax.inject.Singleton


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Module
class ViewModelModule {

    @Singleton
    @Provides
    fun viewModelFactory(
        providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    fun provideHomeViewModel(
        appUseCase: AppUseCase
    ): ViewModel =
        PostViewModel(appUseCase)

}