package com.example.test_task_1.ui_component.main_screen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.DarkGrey
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun CardWithText(
    amount: Double,
    label: String,
    width: Dp,
    maxSymbols: Int = 6
) {
    Log.d("CardWithText", "amountTransform: $amount")

    Card(
        modifier = Modifier
            .width(width)
            .border(2.dp, color = Color(0xFFE54B4B), shape = RoundedCornerShape(30.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (amount < 0) {
                    "0" + " ₽"
                } else if (amount.toInt().toString().length > maxSymbols) {
                    amount.toInt().toString().substring(0, maxSymbols) + "+" + " ₽"
                } else {
                    amount.toInt().toString() + " ₽"

                },
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                color = DarkGrey,
                fontFamily = customFont_roboto_regular,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Text(
                text = label,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = DarkGrey,
                fontFamily = customFont_roboto_regular,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
            )
        }
    }
}