package com.azuka.networkcache.data

import com.azuka.networkcache.base.ErrorResponse


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val errorData: ErrorResponse? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(errorData: ErrorResponse? = null) :
        Resource<T>(data = null, errorData = errorData)
}