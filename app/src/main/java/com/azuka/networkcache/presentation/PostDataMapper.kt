package com.azuka.networkcache.presentation

import com.azuka.networkcache.base.utils.Mapper
import com.azuka.networkcache.data.local.entity.PostEntity
import com.azuka.networkcache.data.remote.response.PostResponse
import com.azuka.networkcache.domain.model.Post


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

object PostDataMapper : Mapper<PostEntity, Post, PostResponse>() {
    override fun mapEntityToDomain(entity: PostEntity): Post = with(entity) {
        Post(id, userId, title, body)
    }

    override fun mapDomainToEntity(dto: Post): PostEntity = with(dto) {
        PostEntity(id, userId, title, body)
    }

    override fun mapResponseToEntity(response: PostResponse): PostEntity = with(response) {
        PostEntity(id, userId, title, body)
    }

    override fun mapResponseToDomain(response: PostResponse): Post = with(response) {
        Post(id, userId, title, body)
    }
}