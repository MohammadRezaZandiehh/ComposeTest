package com.example.composetest.screen.GoldScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composetest.components.RoundedIconBox
import com.example.composetest.model.Product
import com.example.composetest.remote.NetworkResult
import com.example.composetest.viewModel.HomeViewModel

@Composable
fun GoldScreen() {
    GetSuperMarketAmazingProducts()
}

@Composable
fun GetSuperMarketAmazingProducts(
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        getDataFromServer(viewModel)
    }

    val product by viewModel.superMarketProduct.collectAsState()
    var superMarketProductList by remember { mutableStateOf<List<Product>>(emptyList()) }


    when (product) {
        is NetworkResult.Success -> superMarketProductList = product.data ?: emptyList()
        is NetworkResult.Error -> Log.e("3636", "Top Slider error : ${product.message}")
        is NetworkResult.Loading -> {}
    }

    //create your compose ui and use superMarketProductList:
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow() {
            items(superMarketProductList) { item ->
                RoundedIconBox(title = item.name, image = rememberAsyncImagePainter(item.image))
            }
        }
    }
}

private suspend fun getDataFromServer(viewModel: HomeViewModel) {
    viewModel.getSuperMarketAmazingProducts()
}