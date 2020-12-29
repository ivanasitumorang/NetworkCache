package com.azuka.networkcache.data.remote.response

import com.azuka.networkcache.base.ErrorResponse


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorResponse: ErrorResponse) : ApiResponse<Nothing>()
    data class Empty(val code: Int, val message: String) : ApiResponse<Nothing>()
}