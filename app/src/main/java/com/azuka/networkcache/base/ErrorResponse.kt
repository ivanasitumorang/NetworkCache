package com.azuka.networkcache.base


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

data class ErrorResponse(
    val code: Int = -1,
    val message: String? = "",
    val exception: Exception? = null
)