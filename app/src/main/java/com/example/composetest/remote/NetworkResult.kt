package com.example.composetest.remote

sealed class NetworkResult<T>(
    val message: Loading<Any> = null,
    val data: T? = null
) {
    class Success<T>(message: String, data: T) : NetworkResult<T>(message, data)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(message, data)
    class Loading<T> : NetworkResult<T>()
}
