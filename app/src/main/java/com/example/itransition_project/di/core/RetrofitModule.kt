package com.example.itransition_project.di.core

import com.example.data.api.repository.ApiImageRepository
import com.example.data.api.repository.ApiTextRepository
import com.squareup.picasso.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_IMAGE_URL = "https://https://picsum.photos/v2/list/"
private const val BASE_TEXT_URL = "https://api.adviceslip.com/"

@Module
class RetrofitModule {

    @Provides
    fun provideTextRetrofit(): ApiTextRepository {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_TEXT_URL)
            .build()
        return retrofit.create()
    }

    @Provides
    fun provideImageRetrofit(): ApiImageRepository {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_IMAGE_URL)
            .build()
        return retrofit.create()
    }

//    @Provides
//    fun provideInterceptor(): OkHttpClient {
//        var loggingInterceptor: HttpLoggingInterceptor
//        if (BuildConfig.DEBUG) {
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .build()
//    }
}