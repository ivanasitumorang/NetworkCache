package com.azuka.networkcache.domain.usecase

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class AppUseCaseImpl(private val repository: AppRepository) : AppUseCase {
    override fun getPosts(): Flow<Resource<List<Post>>> {
        return repository.getPosts()
    }

    override fun searchPost(query: String): Flow<Resource<List<Post>>> {
        return repository.searchPost(query)
    }
}