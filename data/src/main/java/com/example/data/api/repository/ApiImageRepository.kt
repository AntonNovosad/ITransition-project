package com.example.data.api.repository

import com.example.data.api.apiModel.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiImageRepository {

    @GET()
    fun getUsers(): Response<List<User>>
}