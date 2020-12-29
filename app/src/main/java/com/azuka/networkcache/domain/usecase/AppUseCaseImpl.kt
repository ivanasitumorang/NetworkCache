package com.azuka.networkcache.domain.usecase

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.model.Post
import kotlinx.coroutines.flow.Flow

class AppUseCaseImpl : AppUseCase {
    override fun getPosts(): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }

    override fun searchPost(query: String): Flow<Resource<List<Post>>> {
        TODO("Not yet implemented")
    }
}