package com.cls.retrofitwithcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cls.retrofitwithcompose.data.model.Category
import com.cls.retrofitwithcompose.data.repository.CategoryRepository
import com.cls.retrofitwithcompose.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel() {
    val repository = CategoryRepository()
    private val _categories = MutableStateFlow<UiState<List<Category>>>(UiState.Loading)
    val categories = _categories.asStateFlow()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _categories.value = UiState.Loading
            try {
                val response = repository.getCategories()
                _categories.value = UiState.Success(response.categories)
            }catch (e: Exception){
                _categories.value = UiState.Error(e.message ?: "Something went wrong")
            }
        }
    }

    fun retryFetchCategories() {
        fetchCategories()
    }

}