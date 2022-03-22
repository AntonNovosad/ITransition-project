package com.example.data.repository

import com.example.domain.repository.TextRepository
import kotlin.random.Random

class TextRepositoryImpl() : TextRepository {
    private val random: Random = Random(10000)
    override fun getTextData(): String {
        return "Text ${random.nextInt().toString()}"
    }
}