package com.azuka.networkcache.di.module

import android.app.Application
import android.content.Context
import com.azuka.base.external.CoroutineContextProvider
import com.azuka.networkcache.data.local.LocalDataSource
import com.azuka.networkcache.data.local.LocalDataSourceImpl
import com.azuka.networkcache.data.local.room.PostDao
import com.azuka.networkcache.data.remote.AppRepositoryImpl
import com.azuka.networkcache.data.remote.RemoteDataSource
import com.azuka.networkcache.data.remote.RemoteDataSourceImpl
import com.azuka.networkcache.data.remote.network.AppNetworkService
import com.azuka.networkcache.domain.repository.AppRepository
import com.azuka.networkcache.domain.usecase.AppUseCase
import com.azuka.networkcache.domain.usecase.AppUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Module
class RepositoryModule() {
    @Singleton
    @Provides
    fun provideLocalDataSource(
        postDao: PostDao,
        coroutineContextProvider: CoroutineContextProvider
    ): LocalDataSource =
        LocalDataSourceImpl(postDao, coroutineContextProvider)

    @Singleton
    @Provides
    fun provideRemoteDataSource(networkService: AppNetworkService): RemoteDataSource =
        RemoteDataSourceImpl(networkService)

    @Singleton
    @Provides
    fun provideAppRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): AppRepository =
        AppRepositoryImpl(localDataSource, remoteDataSource)

    @Singleton
    @Provides
    fun provideUseCase(
        repository: AppRepository
    ): AppUseCase = AppUseCaseImpl(repository)
}