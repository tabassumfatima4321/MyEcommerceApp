package com.dawaai.myecommerceapp.di

import com.dawaai.myecommerceapp.remotedatasource.ProductRemoteDataSource
import com.dawaai.myecommerceapp.repository.ProductRepository
import com.dawaai.myecommerceapp.helper.RETROFIT_INS
import com.dawaai.myecommerceapp.helper.RETROFIT_SERVICE
import com.dawaai.myecommerceapp.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Named(RETROFIT_SERVICE)
    fun provideRetrofitServices(@Named(RETROFIT_INS) retrofit: Retrofit): RetrofitService =
        retrofit.create(RetrofitService::class.java)
    @Singleton
    @Provides
    fun provideLoginRemoteDataSource(@Named(RETROFIT_SERVICE) retrofitService: RetrofitService) =
        ProductRemoteDataSource(retrofitService)



    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: ProductRemoteDataSource) =
        ProductRepository(remoteDataSource)

}