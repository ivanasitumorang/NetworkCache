package com.azuka.networkcache.data.remote

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.data.local.LocalDataSource
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class AppRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : AppRepository {
    override fun getPosts(): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }

    override fun searchPost(query: String): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }
}