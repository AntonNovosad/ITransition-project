package com.example.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User): Long

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Long): User

}