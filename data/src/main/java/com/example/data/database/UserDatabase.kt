package com.example.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.data.dao.UserDao
import com.example.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}