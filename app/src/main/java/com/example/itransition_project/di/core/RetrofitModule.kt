package com.example.itransition_project.di.core

import com.example.data.api.repository.ApiImageRepository
import com.example.data.api.repository.ApiTextRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_IMAGE_URL = "https://picsum.photos/v2/"
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
}