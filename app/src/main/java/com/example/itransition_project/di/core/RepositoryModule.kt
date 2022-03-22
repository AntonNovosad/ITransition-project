package com.example.itransition_project.di.core

import com.example.data.repository.ImageRepositoryImpl
import com.example.data.repository.TextRepositoryImpl
import com.example.domain.repository.ImageRepository
import com.example.domain.repository.TextRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideImageRepository(): ImageRepository {
        return ImageRepositoryImpl()
    }

    @Provides
    fun provideTextRepository(): TextRepository {
        return TextRepositoryImpl()
    }
}