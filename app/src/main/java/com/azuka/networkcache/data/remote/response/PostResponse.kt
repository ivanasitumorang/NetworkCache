package com.azuka.networkcache.data.remote.response


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

data class PostResponse(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)