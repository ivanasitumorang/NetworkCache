package com.azuka.networkcache.data.remote

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.repository.AppRepository
import com.azuka.networkcache.domain.model.Post
import kotlinx.coroutines.flow.Flow

class AppRepositoryImpl : AppRepository {
    override fun getPosts(): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }

    override fun searchPost(query: String): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }
}