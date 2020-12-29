package com.azuka.networkcache.di

import android.content.Context
import com.azuka.base.external.CoroutineContextProvider
import com.azuka.networkcache.base.ViewModelFactory
import com.azuka.networkcache.data.local.LocalDataSource
import com.azuka.networkcache.data.local.room.PostDao
import com.azuka.networkcache.data.local.room.PostDatabase
import com.azuka.networkcache.data.remote.RemoteDataSource
import com.azuka.networkcache.di.module.*
import com.azuka.networkcache.domain.repository.AppRepository
import com.azuka.networkcache.domain.usecase.AppUseCase
import com.azuka.networkcache.feature.PostActivity
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(postActivity: PostActivity)

    //    fun viewModelFactory(): ViewModelFactory
    fun appCoroutineContextProvider(): CoroutineContextProvider
    fun networkProvider(): Retrofit
    fun restDao(): PostDao
    fun appUseCase(): AppUseCase
    fun appRepository(): AppRepository
    fun database(): PostDatabase
    fun local(): LocalDataSource
    fun remote(): RemoteDataSource
}