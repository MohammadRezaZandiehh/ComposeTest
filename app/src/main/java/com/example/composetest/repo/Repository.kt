package com.example.composetest.repo

import com.example.composetest.model.Product
import com.example.composetest.model.ResponseResult
import com.example.composetest.remote.NetworkResult
import retrofit2.Response

interface Repository {
    suspend fun getSuperMarketAmazingProducts(): NetworkResult<List<Product>>
}