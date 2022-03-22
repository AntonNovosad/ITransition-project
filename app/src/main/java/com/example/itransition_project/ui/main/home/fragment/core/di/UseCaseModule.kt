package com.example.itransition_project.ui.main.home.fragment.core.di

import com.example.domain.repository.ImageRepository
import com.example.domain.repository.TextRepository
import com.example.domain.usecase.HomeUseCase
import com.example.domain.usecase.HomeUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideUseCase(
        textRepository: TextRepository,
        imageRepository: ImageRepository
    ): HomeUseCase {
        return HomeUseCaseImpl(textRepository, imageRepository)
    }
}