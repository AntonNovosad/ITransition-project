package com.example.itransition_project.di.core

import com.example.itransition_project.logger.BaseLogger
import com.example.itransition_project.logger.Logger
import dagger.Module
import dagger.Provides

@Module
class LoggerModule {

    @Provides
    fun provideLogger(): Logger {
        return BaseLogger()
    }
}