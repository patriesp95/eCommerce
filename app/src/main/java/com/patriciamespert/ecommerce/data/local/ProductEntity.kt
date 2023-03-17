package com.patriciamespert.ecommerce.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patriciamespert.ecommerce.domain.model.INVALID_PRICE
import com.patriciamespert.ecommerce.domain.model.Product

@Entity
data class ProductEntity (
    @PrimaryKey
    val id: String,
    val name: String = "",
    val brand: String = "",
    val price: Int = INVALID_PRICE,
    val image: String = ""
)

fun ProductEntity.mapToProduct(): Product {
    return Product(
        id = id,
        brand = brand,
        name = name,
        price = price,
        image = image
    )
}

fun List<ProductEntity>.mapToProductList(): List<Product>{
    return this.map { it.mapToProduct() }
}