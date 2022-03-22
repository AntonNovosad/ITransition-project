package com.example.data.repository

import com.example.domain.repository.ImageRepository
import kotlin.random.Random

class ImageRepositoryImpl() : ImageRepository {
    private val random: Random = Random(10000)
    override fun getImageData(): String {
        return "Image ${random.nextInt().toString()}"
    }
}