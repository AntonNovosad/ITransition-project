package com.example.domain.repository

import com.example.entity.models.ImageEntity
import kotlinx.coroutines.flow.Flow


interface ImageRepository {
    fun getImageData(): Flow<ImageEntity>
}