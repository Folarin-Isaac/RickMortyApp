package com.example.rickmortyapp.api

import com.example.rickmortyapp.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("character")
    suspend fun getCharacter(@Query("page") page: Int): Response<ApiResponse>
}