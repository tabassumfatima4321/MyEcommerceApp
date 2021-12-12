package com.dawaai.myecommerceapp.di

import com.dawaai.myecommerceapp.helper.BASE_URL
import com.dawaai.myecommerceapp.helper.OK_HTTP
import com.dawaai.myecommerceapp.helper.RETROFIT_INS
import com.dawaai.myecommerceapp.helper.RETROFIT_SERVICE
import com.dawaai.myecommerceapp.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named(OK_HTTP)
    fun providesOkHttpClient(httpLoggingInterceptor:
                             HttpLoggingInterceptor):
            OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .build()


    @Provides
    @Singleton
    @Named(RETROFIT_INS)
    fun provideRetrofit(
        @Named(OK_HTTP) okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()





}
