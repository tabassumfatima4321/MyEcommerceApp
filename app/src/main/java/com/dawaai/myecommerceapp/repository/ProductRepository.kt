package com.dawaai.myecommerceapp.repository

import com.dawaai.myecommerceapp.remotedatasource.ProductRemoteDataSource
import javax.inject.Inject

class ProductRepository  @Inject constructor (
  private val remoteDataSource: ProductRemoteDataSource
){
   suspend fun getProducts() = remoteDataSource.getProducts()


}