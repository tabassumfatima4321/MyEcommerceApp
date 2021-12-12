package com.dawaai.myecommerceapp.activity

import javax.inject.Inject

class ProductRepository  @Inject constructor (
  private val remoteDataSource: ProductRemoteDataSource
){
   suspend fun getProducts() = remoteDataSource.getProducts()


}