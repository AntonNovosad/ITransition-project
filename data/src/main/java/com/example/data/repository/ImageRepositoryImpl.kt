package com.example.data.repository

import com.example.data.api.repository.ApiImageRepository
import com.example.domain.repository.ImageRepository
import com.example.entity.models.ImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class ImageRepositoryImpl(
    private var imageInterface: ApiImageRepository
) : ImageRepository {

    override fun getImageData(): Flow<ImageEntity> = flow {

        val list = imageInterface.getUsers().execute().body()
        val url = list?.get(Random.nextInt(list.size))!!.download_url

        val imageEntity = ImageEntity(
            image = url
        )
        emit(imageEntity)
    }
}