package com.example.data.repository

import com.example.data.dao.UserDao
import com.example.data.database.UserDatabase
import com.example.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDatabase: UserDatabase) {

    private var userDao: UserDao = userDatabase.userDao()

    fun getAll(): List<User> {
        return userDao.getAll()
    }

    fun getUserById(id: Long): User {
        return userDao.getById(id)
    }

    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.addUser(user)
        }
    }
}