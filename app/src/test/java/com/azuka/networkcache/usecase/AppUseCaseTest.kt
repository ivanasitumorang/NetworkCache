package com.azuka.networkcache.usecase

import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.repository.AppRepository
import com.azuka.networkcache.domain.usecase.AppUseCaseImpl
import com.azuka.networkcache.util.TestUtils
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test


/**
 * Created by ivanaazuka on 30/12/20.
 * Android Engineer
 */

class AppUseCaseTest {
    private val mockRepository: AppRepository = mock()
    private val useCase = AppUseCaseImpl(mockRepository)
    private val dummyPosts = TestUtils.getPostsFromJson()
    private val dummyEmptyPost = TestUtils.getEmptyPost()

    @Test
    fun `get posts successfully`() {
        val flowResourcePosts = flowOf(Resource.Success(dummyPosts))
        doReturn(flowResourcePosts)
            .`when`(mockRepository)
            .getPosts()

        val postResourceLists = useCase.getPosts()

        verify(mockRepository).getPosts()

        assertNotNull(postResourceLists)

        runBlocking {
            val actualPosts = postResourceLists.first().data
            assertNotEquals(0, actualPosts?.size)
        }
    }

    @Test
    fun `get search results with query 'magnam'`() {
        val titleToSearch = "magnam"
        val dummySearchPost = TestUtils.getSearchPosts(titleToSearch)

        val flowResourcePosts = flowOf(Resource.Success(dummySearchPost))
        doReturn(flowResourcePosts)
            .`when`(mockRepository)
            .searchPost(titleToSearch)

        val postResourceLists = useCase.searchPost(titleToSearch)

        verify(mockRepository).searchPost(titleToSearch)

        assertNotNull(postResourceLists)

        runBlocking {
            val actualPosts = postResourceLists.first().data
            assertEquals(dummySearchPost, actualPosts)
            assertEquals(dummySearchPost.size, actualPosts?.size)
        }
    }

    @Test
    fun `get search results when the posts are empty`() {
        val flowResourcePosts = flowOf(Resource.Success(dummyEmptyPost))
        doReturn(flowResourcePosts)
            .`when`(mockRepository)
            .getPosts()

        val postResourceLists = useCase.getPosts()

        verify(mockRepository).getPosts()

        assertNotNull(postResourceLists)

        runBlocking {
            val actualPosts = postResourceLists.first().data
            assertEquals(0, actualPosts?.size)
        }
    }

}