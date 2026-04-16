package com.cls.retrofitwithcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessage(
    errorMessage: String?,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Snackbar(
            action = {
                TextButton(onClick = onRetry) {
                    Text("Retry")
                }
            }
        ) {
            Text(text = errorMessage ?: "Failed to load categories.")
        }
    }
}