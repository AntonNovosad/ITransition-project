package com.example.domain.usecase

import com.example.domain.repository.ImageRepository
import com.example.domain.repository.TextRepository
import com.example.entity.models.HomeDataEntity
import kotlinx.coroutines.flow.*

class HomeUseCaseImpl(
    private val textRepository: TextRepository,
    private val imageRepository: ImageRepository
) : HomeUseCase {

    override fun getHomeDataEntity(): Flow<List<HomeDataEntity>> = flow {
        val list = mutableListOf<HomeDataEntity>()
        while (list.size < 10) {
            val text = textRepository.getTextData()
            val image = imageRepository.getImageData()
            val result = combine(text, image) { a, b -> HomeDataEntity(a, b) }
            result.collect { dataEntity ->
                list.add(dataEntity)
            }
        }
        emit(list)

    }
}