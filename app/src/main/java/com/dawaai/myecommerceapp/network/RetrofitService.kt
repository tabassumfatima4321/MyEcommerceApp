package com.dawaai.myecommerceapp.network

import com.dawaai.myecommerceapp.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("products")
    suspend fun getProducts() : Response<List<Product>>


}