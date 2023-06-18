package com.example.composetest.repo

import com.example.composetest.model.Product
import com.example.composetest.remote.BaseApiResponse
import com.example.composetest.remote.HomeApiInterface
import com.example.composetest.remote.NetworkResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val homeApiInterface: HomeApiInterface
) : BaseApiResponse()/*, Repository*/ {
    /*override*/ suspend fun getSuperMarketAmazingProducts(): NetworkResult<List<Product>> = safeApiCall {
        homeApiInterface.getProduct()
    }
}