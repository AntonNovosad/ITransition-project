package com.example.data.repository

import com.example.domain.repository.ImageRepository
import com.example.entity.models.ImageEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class ImageRepositoryImpl() : ImageRepository {
    private val random: Random = Random(10000)

    override fun getImageData(): Flow<ImageEntity> = flow {
        delay(2000)
        val image = "Image ${random.nextInt().toString()}"
        var imageEntity = ImageEntity(image = image)
        emit(imageEntity)
    }
}