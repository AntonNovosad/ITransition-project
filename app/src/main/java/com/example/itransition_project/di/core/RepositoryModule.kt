package com.example.itransition_project.di.core

import com.example.data.api.repository.ApiImageRepository
import com.example.data.api.repository.ApiTextRepository
import com.example.data.repository.ImageRepositoryImpl
import com.example.data.repository.TextRepositoryImpl
import com.example.domain.repository.ImageRepository
import com.example.domain.repository.TextRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideTextRepository(apiTextRepository: ApiTextRepository): TextRepository {
        return TextRepositoryImpl(apiTextRepository)
    }

    @Provides
    fun provideImageRepository(apiImageRepository: ApiImageRepository): ImageRepository {
        return ImageRepositoryImpl(apiImageRepository)
    }
}