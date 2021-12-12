package com.dawaai.myecommerceapp.remotedatasource

import com.dawaai.myecommerceapp.helper.RETROFIT_INS
import com.dawaai.myecommerceapp.network.RetrofitService
import javax.inject.Inject
import javax.inject.Named


class ProductRemoteDataSource  @Inject constructor (@Named(RETROFIT_INS) private  val apiService: RetrofitService)
{
    suspend fun getProducts() = apiService.getProducts()


}