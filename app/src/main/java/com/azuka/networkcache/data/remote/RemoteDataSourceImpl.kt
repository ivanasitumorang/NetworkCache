package com.azuka.networkcache.data.remote

import com.azuka.networkcache.data.remote.network.AppNetworkService
import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(private val networkService: AppNetworkService) : RemoteDataSource {
    override fun getPosts(): Flow<ApiResponse<List<PostResponse>>> {
        TODO("Not yet implemented")
    }
}