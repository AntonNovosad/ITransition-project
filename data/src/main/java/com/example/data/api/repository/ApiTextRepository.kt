package com.example.data.api.repository

import com.example.data.api.apiModel.SlipEntity
import retrofit2.Call
import retrofit2.http.GET

interface ApiTextRepository {

    @GET("advice")
    fun getSlipEntity(): Call<SlipEntity>
}