package com.azuka.networkcache.data.remote

import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getPosts(): Flow<ApiResponse<List<PostResponse>>> {
        TODO("Not yet implemented")
    }
}