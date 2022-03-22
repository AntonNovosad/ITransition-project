package com.example.data.repository

import com.example.domain.repository.TextRepository
import com.example.entity.models.TextEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class TextRepositoryImpl() : TextRepository {

    private val random: Random = Random(10000)

    override fun getTextData(): Flow<TextEntity> = flow {
        delay(1000)
        val text = "Text ${random.nextInt().toString()}"
        var textEntity = TextEntity(text = text)
        emit(textEntity)
    }
}