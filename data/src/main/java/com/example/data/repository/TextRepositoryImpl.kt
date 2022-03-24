package com.example.data.repository

import com.example.data.api.repository.ApiTextRepository
import com.example.domain.repository.TextRepository
import com.example.entity.models.TextEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.await
import javax.inject.Inject

class TextRepositoryImpl (
    private var textRepository: ApiTextRepository
) : TextRepository {

    override fun getTextData(): Flow<TextEntity> = flow {
        delay(1000)

        val textEntity = TextEntity(
            text = textRepository.getSlipEntity().execute().body()!!.slip.advice
        )
        emit(textEntity)
    }
}