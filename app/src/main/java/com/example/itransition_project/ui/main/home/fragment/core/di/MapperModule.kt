package com.example.itransition_project.ui.main.home.fragment.core.di

import com.example.ui.home.model.Mapper
import com.example.ui.home.model.MapperImpl
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideMapper(): Mapper {
        return MapperImpl()
    }
}