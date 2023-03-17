package com.patriciamespert.ecommerce.data.di

import com.patriciamespert.ecommerce.data.repository.ProductRepositoryImpl
import com.patriciamespert.ecommerce.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductsRepository(productRepository: ProductRepositoryImpl):ProductRepository
}