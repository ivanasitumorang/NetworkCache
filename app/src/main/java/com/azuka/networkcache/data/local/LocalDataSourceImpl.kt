package com.azuka.networkcache.data.local

import com.azuka.networkcache.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl : LocalDataSource {
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