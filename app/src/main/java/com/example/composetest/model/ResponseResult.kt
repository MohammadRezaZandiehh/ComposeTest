package com.example.composetest.model

data class ResponseResult<T>(
    val message: String,
    val data: T,
    val success: Boolean
)
