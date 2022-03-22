package com.example.domain.usecase

import com.example.domain.repository.ImageRepository
import com.example.domain.repository.TextRepository
import com.example.entity.models.HomeDataEntity

class HomeUseCaseImpl(
    private val textRepository: TextRepository,
    private val imageRepository: ImageRepository
) : HomeUseCase {

    override fun getHomeDataEntity(): List<HomeDataEntity> {
        val list = mutableListOf<HomeDataEntity>()
        while (list.size < 10) {
           var text = textRepository.getTextData()
           var image = imageRepository.getImageData()
            list.add(HomeDataEntity(text, image))
        }
        return list
    }
}