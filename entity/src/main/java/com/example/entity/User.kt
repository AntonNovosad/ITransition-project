package com.example.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Long,
    val email: String,
    val password: String
)