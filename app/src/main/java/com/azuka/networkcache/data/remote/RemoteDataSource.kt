package com.azuka.networkcache.data.remote

import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

interface RemoteDataSource {
    fun getPosts(): Flow<ApiResponse<List<PostResponse>>>
}