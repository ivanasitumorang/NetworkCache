package com.azuka.networkcache.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azuka.networkcache.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Dao
interface PostDao {

    @Query("SELECT * FROM t_post")
    fun getPosts(): Flow<List<PostEntity>>

    @Query("SELECT * FROM t_post WHERE title LIKE '%' || :query || '%'")
    fun searchPosts(query: String): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(postEntities: List<PostEntity>)
}