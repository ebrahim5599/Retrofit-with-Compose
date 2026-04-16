package com.cls.retrofitwithcompose.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.cls.retrofitwithcompose.data.model.Category

@Composable
fun CategoryList(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit = {}
) {
    LazyColumn {
        items(
            items = categories,
            key = { it.id }
        ) { category ->
            CategoryCard(
                category = category,
                onClick = onCategoryClick
            )
        }
    }
}