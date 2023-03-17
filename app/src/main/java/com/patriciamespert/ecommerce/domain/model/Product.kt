package com.patriciamespert.ecommerce.domain.model

import com.patriciamespert.ecommerce.data.local.ProductEntity

const val INVALID_PRICE = -1

data class Product(
    val id: String? = null,
    val name: String = "",
    val brand: String = "",
    val price: Int = INVALID_PRICE,
    val image: String = ""
)

fun Product.mapToProductEntity(): ProductEntity {
    return ProductEntity(
        id.orEmpty(),
        name,
        brand,
        price,
        image
    )
}

fun List<Product>.mapToProductEntityList(): List<ProductEntity>{
    return this.map { it.mapToProductEntity() }
}