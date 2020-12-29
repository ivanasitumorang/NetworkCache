package com.azuka.networkcache.data.local

import com.azuka.base.external.CoroutineContextProvider
import com.azuka.networkcache.data.local.entity.PostEntity
import com.azuka.networkcache.data.local.room.PostDao
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val postDao: PostDao,
    private val coroutineContextProvider: CoroutineContextProvider
) : LocalDataSource {
    override fun getPosts(): Flow<List<PostEntity>> {
        TODO("Not yet implemented")
    }

    override fun searchPost(query: String): Flow<List<PostEntity>> {
        TODO("Not yet implemented")
    }

    override fun insertPosts() {
        TODO("Not yet implemented")
    }
}