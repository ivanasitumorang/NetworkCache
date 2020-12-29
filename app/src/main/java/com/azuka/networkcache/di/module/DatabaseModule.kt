package com.azuka.networkcache.di.module

import android.content.Context
import androidx.room.Room
import com.azuka.networkcache.data.local.room.PostDao
import com.azuka.networkcache.data.local.room.PostDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): PostDatabase = Room.databaseBuilder(
        context,
        PostDatabase::class.java,
        "PostDatabase.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun providePostDao(database: PostDatabase): PostDao = database.postDao()
}