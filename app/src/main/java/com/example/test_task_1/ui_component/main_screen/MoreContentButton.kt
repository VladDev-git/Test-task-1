package com.example.test_task_1.ui_component.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.ProgressBarGrey
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun MoreContentButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Смотреть все",
            color = ProgressBarGrey,
            fontSize = 16.sp,
            fontFamily = customFont_roboto_regular,
            fontWeight = FontWeight(400),
        )
    }
}