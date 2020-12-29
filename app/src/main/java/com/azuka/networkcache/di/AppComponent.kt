package com.azuka.networkcache.di

import android.content.Context
import com.azuka.networkcache.di.module.AppModule
import com.azuka.networkcache.di.module.DatabaseModule
import com.azuka.networkcache.di.module.NetworkModule
import com.azuka.networkcache.di.module.RepositoryModule
import com.azuka.networkcache.feature.PostActivity
import dagger.BindsInstance
import dagger.Component
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
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(postActivity: PostActivity)
}