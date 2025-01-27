package com.example.test_task_1.ui_component.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.DarkGrey
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun DreamsListButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp, start = 10.dp, end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .height(44.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = DarkGrey),
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ваши желания",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = customFont_roboto_regular,
                        fontWeight = FontWeight(500)
                    )
                }
            }
        }
    }
}