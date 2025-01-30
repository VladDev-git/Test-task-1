package com.example.test_task_1.ui_component.income_expense_screen

import RedGradientBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun SectionNameBar(
    sectionName: String,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp, bottom = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .height(64.dp)
                .clip(shape = RoundedCornerShape(40.dp))
                .RedGradientBackground()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                        painter = painterResource(id = com.example.test_task_1.R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .clickable(
                        onClick = {
                            onBackClick()
                        }
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = sectionName,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = customFont_roboto_regular
                )
            }
//            Box(
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(start = 10.dp),
//                contentAlignment = Alignment.CenterStart
//            ) {
//
//            }
        }
    }
}