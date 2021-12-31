package com.flixmobility.challenge.di

import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            addInterceptor(HeadersInterceptor())
        }.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://global.api-dev.flixbus.com/mobile/v1/network/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    class HeadersInterceptor: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val modifiedRequest = chain.request().newBuilder()
                .header("X-Api-Authentication", "intervIEW_TOK3n")
                .build()
            return chain.proceed(modifiedRequest)
        }
    }
}