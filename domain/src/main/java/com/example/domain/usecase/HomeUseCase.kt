package com.example.domain.usecase

import com.example.entity.models.HomeDataEntity
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun getHomeDataEntity(): Flow<List<HomeDataEntity>>
}