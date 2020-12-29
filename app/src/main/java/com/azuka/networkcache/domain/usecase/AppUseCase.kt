package com.azuka.networkcache.domain.usecase

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.model.Post
import kotlinx.coroutines.flow.Flow


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

interface AppUseCase {
    fun getPosts(): Flow<Resource<List<Post>>>
    fun searchPost(query: String): Flow<Resource<List<Post>>>
}