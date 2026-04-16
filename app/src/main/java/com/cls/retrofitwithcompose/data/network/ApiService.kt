package com.cls.retrofitwithcompose.data.network

import com.cls.retrofitwithcompose.data.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}
