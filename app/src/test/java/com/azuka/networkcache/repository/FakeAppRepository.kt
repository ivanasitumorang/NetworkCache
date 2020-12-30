package com.azuka.networkcache.repository

import com.azuka.networkcache.data.NetworkBoundResource
import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.data.local.LocalDataSource
import com.azuka.networkcache.data.remote.RemoteDataSource
import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.domain.repository.AppRepository
import com.azuka.networkcache.presentation.PostDataMapper
import kotlinx.coroutines.flow.*


/**
 * Created by ivanaazuka on 30/12/20.
 * Android Engineer
 */

class FakeAppRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : AppRepository {
    override fun getPosts(): Flow<Resource<List<Post>>> {

        return object : NetworkBoundResource<List<PostResponse>, List<Post>>() {
            override fun loadFromDB(): Flow<List<Post>> {
                return localDataSource.getPosts().map {
                    PostDataMapper.mapEntitiesToDomains(it)
                }
            }

            override fun shouldFetch(data: List<Post>?): Boolean = data.isNullOrEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<PostResponse>>> {
                return remoteDataSource.getPosts()
            }

            override suspend fun saveCallResult(data: List<PostResponse>) {
                val postList = PostDataMapper.mapResponsesToEntities(data)
                localDataSource.insertPosts(postList)
            }

        }.asFlow()
    }

    override fun searchPost(query: String): Flow<Resource<List<Post>>> {
        return flow {
            emit(Resource.Loading())
            val loadFromDb = localDataSource.searchPost(query).map {
                PostDataMapper.mapEntitiesToDomains(it)
            }

            emitAll(loadFromDb.map {
                Resource.Success(it)
            })
        }
    }
}