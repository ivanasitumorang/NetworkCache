package com.azuka.networkcache.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.domain.usecase.AppUseCase
import com.azuka.networkcache.presentation.PostViewModel
import com.azuka.networkcache.util.TestUtils
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by ivanaazuka on 30/12/20.
 * Android Engineer
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PostViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: AppUseCase

    @Mock
    private lateinit var observer: Observer<List<Post>>

    private lateinit var viewModel: PostViewModel
    private val dummyPosts = TestUtils.getPostsFromJson()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = PostViewModel(useCase)
    }

    @Test
    fun `get posts successfully`() {

        val returnedFlowPost: Flow<Resource<List<Post>>> = flow {
            emit(Resource.Success(dummyPosts))
        }

        `when`(useCase.getPosts()).thenReturn(returnedFlowPost)

        viewModel.getPosts()

        verify(useCase).getPosts()

        viewModel.postList.observeForever(observer)


    }

    @After
    fun tearDown() { // reset main dispatcher to the original Main dispatcher
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }
}