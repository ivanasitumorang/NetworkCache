package com.azuka.networkcache.data.remote.network

import com.azuka.networkcache.data.remote.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

interface AppNetworkService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<PostResponse>>
}