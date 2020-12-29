package com.azuka.networkcache.domain.model


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

data class Post(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)