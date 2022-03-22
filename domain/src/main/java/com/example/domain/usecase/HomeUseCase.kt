package com.example.domain.usecase

import com.example.entity.models.HomeDataEntity

interface HomeUseCase {
    fun getHomeDataEntity(): List<HomeDataEntity>
}