package com.azuka.networkcache.presentation

import androidx.lifecycle.*
import com.azuka.networkcache.data.Resource
import com.azuka.networkcache.domain.model.Post
import com.azuka.networkcache.domain.usecase.AppUseCase


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

class PostViewModel(private val useCase: AppUseCase) : ViewModel() {

    private val _postList = MediatorLiveData<List<Post>>()
    val postList: LiveData<List<Post>> = _postList

    fun getPosts(query: String? = null) {
        val postDataSource =
            if (query.isNullOrEmpty()) {
                useCase.getPosts().asLiveData()
            } else {
                useCase.searchPost(query).asLiveData()
            }

        _postList.addSource(postDataSource) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    // loading
                }

                is Resource.Success -> {
                    _postList.value = resource.data
                }

                is Resource.Error -> {
                    // error
                }
            }
        }
    }

}