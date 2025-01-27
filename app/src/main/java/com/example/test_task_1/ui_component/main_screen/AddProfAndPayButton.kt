package com.example.test_task_1.ui_component.main_screen

import RedGradientBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.R
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun AddProfAndPayButton(
    onBottomSheetVisibleClick: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .height(56.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .RedGradientBackground()
        ) {
            Button(
                onClick = {
                    onBottomSheetVisibleClick(true)
                },
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = "Plus",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        text = "Добавить доход/расход",
                        modifier = Modifier.padding(start = 7.dp),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = customFont_roboto_regular,
                        fontWeight = FontWeight(500)
                    )
                }
            }
        }
    }
}