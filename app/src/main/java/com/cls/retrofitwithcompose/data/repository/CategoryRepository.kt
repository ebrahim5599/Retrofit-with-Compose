package com.cls.retrofitwithcompose.data.repository

import com.cls.retrofitwithcompose.data.model.CategoryResponse
import com.cls.retrofitwithcompose.data.network.RetrofitClient

class CategoryRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCategories(): CategoryResponse {
        return apiService.getCategories()
    }
}
