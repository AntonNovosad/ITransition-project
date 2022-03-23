package com.example.ui.home.model

import com.example.entity.models.HomeDataEntity

class MapperImpl : Mapper {

    override fun map(list: List<HomeDataEntity>): List<HomeDataUi> {
        return list.map {
            HomeDataUi(it.textEntity.text, it.imageEntity.image)
        }
    }
}