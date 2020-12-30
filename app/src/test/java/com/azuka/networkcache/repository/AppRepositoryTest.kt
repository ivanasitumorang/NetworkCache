package com.azuka.networkcache.repository

import com.azuka.networkcache.data.local.LocalDataSource
import com.azuka.networkcache.data.remote.RemoteDataSource
import com.azuka.networkcache.data.remote.response.ApiResponse
import com.azuka.networkcache.data.remote.response.PostResponse
import com.azuka.networkcache.util.TestUtils
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.`when`


/**
 * Created by ivanaazuka on 30/12/20.
 * Android Engineer
 */

class AppRepositoryTest {
    private val mockRemoteDataSource = mock<RemoteDataSource>()
    private val mockLocalDataSource = mock<LocalDataSource>()
    private val repository = FakeAppRepository(mockLocalDataSource, mockRemoteDataSource)

    private val postResponses = TestUtils.getPostResponsesFromJson()
    private val postEntities = TestUtils.getPostEntities()

    @Test
    fun `get posts successfully`() {
        val flowPostEntities = flowOf(postEntities)
        doReturn(flowPostEntities)
            .`when`(mockLocalDataSource)
            .getPosts()

        val flowPostResponses: Flow<ApiResponse<List<PostResponse>>> =
            flowOf(ApiResponse.Success(postResponses))
        doReturn(flowPostResponses)
            .`when`(mockRemoteDataSource)
            .getPosts()

        doNothing()
            .`when`(mockLocalDataSource)
            .insertPosts(postEntities)

        val postLists = repository.getPosts()

        assertNotNull(postLists)
    }

}