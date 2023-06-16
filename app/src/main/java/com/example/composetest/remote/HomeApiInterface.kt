package com.example.composetest.remote

import com.example.composetest.model.Product
import com.example.composetest.model.ResponseResult
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSuperMarketAmazingProducts")
    suspend fun getProduct(): Response<ResponseResult<List<Product>>>
}