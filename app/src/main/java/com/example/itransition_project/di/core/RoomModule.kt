package com.example.itransition_project.di.core

import android.arch.persistence.room.Room
import android.content.Context
import com.example.data.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) {
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "users"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao()
}