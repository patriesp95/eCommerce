package com.patriciamespert.ecommerce.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.patriciamespert.ecommerce.data.local.ProductDao
import com.patriciamespert.ecommerce.data.local.mapToProductList
import com.patriciamespert.ecommerce.data.remote.FirestoreConstants.PRODUCTS_COLLECTION
import com.patriciamespert.ecommerce.domain.model.Product
import com.patriciamespert.ecommerce.domain.model.mapToProductEntity
import com.patriciamespert.ecommerce.domain.repository.ProductRepository
import com.patriciamespert.ecommerce.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val firestoreInstance: FirebaseFirestore
):ProductRepository {
    override suspend fun fetchAllProducts(): Resource<List<Product>> {
        return try {
            val productList = firestoreInstance.collection(PRODUCTS_COLLECTION)
                .get()
                .await()
                .toObjects(Product::class.java)
            Resource.Success(productList)
        } catch (e: Exception){
            Resource.Error(e)
        }

    }

    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts().mapToProductList()
    }

    override suspend fun insertAllProductsCache(products: List<Product>) {
        productDao.insertAllProducts(products.map { it.mapToProductEntity() })
    }
}