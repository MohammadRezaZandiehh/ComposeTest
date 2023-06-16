package com.example.composetest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest.model.Product
import com.example.composetest.remote.NetworkResult
import com.example.composetest.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _superMarketProduct =
        MutableStateFlow<NetworkResult<List<Product>>>(NetworkResult.Loading())
    val superMarketProduct: StateFlow<NetworkResult<List<Product>>>
        get() = _superMarketProduct

    private val _errorLV = MutableLiveData<String?>()
    val errorLV: LiveData<String?>
        get() = _errorLV

    private val _loadingLV = MutableLiveData<Boolean>()
    val loadingLV: LiveData<Boolean?>
        get() = _loadingLV


    suspend fun getSuperMarketAmazingProducts() {
        viewModelScope.launch {

            repository.getSuperMarketAmazingProducts().also { product ->
                when (product) {
                    is NetworkResult.Success -> {
                        _superMarketProduct.emit(repository.getSuperMarketAmazingProducts()) ?: emptyList<Product>()
                        _loadingLV.value = false
                    }

                    is NetworkResult.Error -> {
                        _errorLV.value = product.message
                        _loadingLV.value = false
                    }

                    is NetworkResult.Loading -> _loadingLV.value = true
                }
            }
        }
    }
}