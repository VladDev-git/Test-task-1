package com.example.test_task_1.ui_component.main_screen.pager_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun IncomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEAFF)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Екран Доходів", color = Color(0xFF3B30FF))
    }
}