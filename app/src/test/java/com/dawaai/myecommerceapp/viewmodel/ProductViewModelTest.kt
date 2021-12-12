package com.dawaai.myecommerceapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dawaai.myecommerceapp.helper.BASE_URL
import com.dawaai.myecommerceapp.network.RetrofitService
import com.dawaai.myecommerceapp.remotedatasource.ProductRemoteDataSource
import com.dawaai.myecommerceapp.repository.ProductRepository
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ProductViewModelTest : TestCase()
{
private  lateinit var productViewModel: ProductViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
   public override fun setUp() {
        super.setUp()
        val httpLoggingInterceptor= HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        val okHttp=  OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .build()

        val apService= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build().create(RetrofitService::class.java)

        val remoteDataSource=ProductRemoteDataSource(apService)
        val productRepository=ProductRepository(remoteDataSource)
        productViewModel= ProductViewModel(productRepository)
    }

    @Test
    fun checkProductData() {
        if (::productViewModel.isInitialized) {
            productViewModel.getProducts()
            assertThat(productViewModel.data != null).isTrue()
        }
    }
}