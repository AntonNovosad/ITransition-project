package com.example.ui.home.model

import com.example.entity.models.HomeDataEntity

interface Mapper {

    fun map(list: List<HomeDataEntity>): List<HomeDataUi>
}