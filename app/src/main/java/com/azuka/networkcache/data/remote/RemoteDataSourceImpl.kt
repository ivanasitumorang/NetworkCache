package com.azuka.networkcache.data.remote

import android.util.Log
import com.azuka.networkcache.base.ErrorResponse
import com.azuka.networkcache.data.remote.network.AppNetworkService
import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSourceImpl(private val networkService: AppNetworkService) : RemoteDataSource {
    override fun getPosts(): Flow<ApiResponse<List<PostResponse>>> {
        return flow {
            try {
                networkService.getPosts().apply {
                    if (isSuccessful) {
                        val responseBody = body() as List<PostResponse>
                        emit(ApiResponse.Success(responseBody))
                    } else {
                        emit(ApiResponse.Empty(code = code(), message = message()))
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(ErrorResponse(-1, e.message, e)))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}