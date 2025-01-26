package com.example.test_task_1.ui_component.main_screen

import RedGradientBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.R
import com.example.test_task_1.ui_component.fonts.customFont_sb_sans_display_semibold

@Composable
fun LogoTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .RedGradientBackground()
                .padding(top = 30.dp),
            contentAlignment = Alignment.Center,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(30.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Column(
                    modifier = Modifier.width(325.dp)
                        .padding(top = 18.dp, bottom = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(51.8.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Фин",
                            fontSize = 24.28.sp,
                            color = Color.White,
                            fontFamily = customFont_sb_sans_display_semibold,
                        )
                        Text(
                            text = "Старт",
                            fontSize = 24.28.sp,
                            fontFamily = customFont_sb_sans_display_semibold,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 4.dp),
                        )
                    }
                }
            }
        }
    }

}