package com.azuka.networkcache.data.local

import com.azuka.networkcache.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

interface LocalDataSource {
    fun getPosts(): Flow<List<PostEntity>>
    fun searchPost(query: String): Flow<List<PostEntity>>
    fun insertPosts(postEntities: List<PostEntity>)
}