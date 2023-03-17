package com.patriciamespert.ecommerce.domain.repository

import com.patriciamespert.ecommerce.domain.model.Product
import com.patriciamespert.ecommerce.utils.Resource

interface ProductRepository {

    suspend fun fetchAllProducts(): Resource<List<Product>>

    suspend fun getAllProducts(): List<Product>

    suspend fun insertAllProductsCache(products: List<Product>)

}