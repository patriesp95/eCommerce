package com.patriciamespert.ecommerce.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM ProductEntity")
    fun getAllProducts():List<ProductEntity>

    @Insert(onConflict = REPLACE)
    fun insertAllProducts(products: List<ProductEntity>)
}