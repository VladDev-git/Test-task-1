package com.example.test_task_1.ui_component.loading_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.test_task_1.ui.theme.ProgressBarGrey

@Composable
fun HorizontalProgressBar(progress: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 10.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .padding(horizontal = 37.5.dp)
        ) {
            drawRoundRect(
                color = ProgressBarGrey,
                size = Size(size.width, size.height),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
            )

            drawRoundRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFEC5F5F).copy(alpha = 0.8f),
                        Color(0xFFDC3939),
                        Color(0xFFEA1414)
                    ),
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width, size.height / 2)
                ),
                size = Size(size.width * progress, size.height),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
            )
        }
    }

}



