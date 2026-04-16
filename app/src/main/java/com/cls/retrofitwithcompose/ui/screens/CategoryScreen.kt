package com.cls.retrofitwithcompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cls.retrofitwithcompose.ui.components.CategoryList
import com.cls.retrofitwithcompose.ui.components.ErrorMessage
import com.cls.retrofitwithcompose.util.UiState
import com.cls.retrofitwithcompose.viewmodel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = viewModel()
) {
    val uiState by viewModel.categories.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meal Categories") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Success -> {
                    CategoryList(
                        categories = state.data,
                        onCategoryClick = { category ->
                            // Here you can navigate to the details screen or perform any other action
                            // based on the selected category
                        }
                    )
                }

                is UiState.Error -> {
                    ErrorMessage(
                        errorMessage = state.errorMessage,
                        onRetry = { viewModel.retryFetchCategories() }
                    )
                }
            }
        }
    }
}