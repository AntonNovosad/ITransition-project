package com.example.itransition_project.di.core

import com.example.data.database.UserDatabase
import com.example.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(userDatabase: UserDatabase): UserRepository {
        return UserRepository(userDatabase)
    }
}