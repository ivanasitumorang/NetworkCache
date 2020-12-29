package com.azuka.networkcache.data.local

import com.azuka.base.external.CoroutineContextProvider
import com.azuka.networkcache.data.local.entity.PostEntity
import com.azuka.networkcache.data.local.room.PostDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LocalDataSourceImpl(
    private val postDao: PostDao,
    private val coroutineContextProvider: CoroutineContextProvider
) : LocalDataSource {
    override fun getPosts(): Flow<List<PostEntity>> {
        return postDao.getPosts()
    }

    override fun searchPost(query: String): Flow<List<PostEntity>> {
        return postDao.getPosts()
    }

    override fun insertPosts(postEntities: List<PostEntity>) {
        CoroutineScope(coroutineContextProvider.backgroundDispatcher()).launch {
            postDao.insertPosts(postEntities)
        }
    }
}