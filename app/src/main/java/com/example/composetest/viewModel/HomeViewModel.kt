package com.example.composetest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest.model.Product
import com.example.composetest.remote.NetworkResult
import com.example.composetest.repo.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: RepositoryImpl) : ViewModel() {
    private val _superMarketProduct =
        MutableStateFlow<NetworkResult<List<Product>>>(NetworkResult.Loading())
    val superMarketProduct: StateFlow<NetworkResult<List<Product>>>
        get() = _superMarketProduct

    var productsListFromServer: Flow<List<Product>>? = null


    suspend fun getSuperMarketAmazingProducts() =
        viewModelScope.launch {
            launch {
                _superMarketProduct.emit(repository.getSuperMarketAmazingProducts())
                _superMarketProduct.map { productList ->
                    productList.data?.filter {
                        it.discountPercent <= 10
                    }
                }
            }
        }
}
