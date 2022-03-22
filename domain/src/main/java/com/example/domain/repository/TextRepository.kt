package com.example.domain.repository

import com.example.entity.models.TextEntity
import kotlinx.coroutines.flow.Flow

interface TextRepository {
    fun getTextData(): Flow<TextEntity>
}