package com.patriciamespert.ecommerce.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciamespert.ecommerce.domain.model.Product
import com.patriciamespert.ecommerce.domain.usecase.GetAllProductsUseCase
import com.patriciamespert.ecommerce.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
): ViewModel() {

    private val _products: MutableLiveData<Resource<List<Product>>> = MutableLiveData()
    val products: LiveData<Resource<List<Product>>>
        get() = _products

    init {
        getAllProducts()
    }

    private fun getAllProducts(){
        viewModelScope.launch {
            val productsList =  getAllProductsUseCase()
            _products.postValue(productsList)
        }

    }

}