package com.example.test_task_1.ui_component.main_screen

import RedGradientBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.R
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui.theme.DarkGrey
import com.example.test_task_1.ui.theme.ProgressBarGrey
import com.example.test_task_1.ui.theme.TextRed
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular
import gradientTextStyle

@Composable
fun MainScreen(

) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            CustomBottomMenu()
        },
        topBar = {
            LogoTopBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundWhite)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 10.dp, start = 22.dp, end = 22.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CardWithText("3 393 ₽", "Расходы", 155.dp)
                        CardWithText("393 ₽", "Накопления", 155.dp)
                    }
                }
                item {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp, start = 22.dp, end = 22.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CardWithText("1 483 393 ₽", "Общий доход", 330.dp)
                    }
                }
                item {
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
                                onClick = {},
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
                item {
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
                item {
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
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .width(330.dp)
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
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(66.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = DarkGrey,
                                    ),
                                    shape = RoundedCornerShape(30.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 25.dp),
                                        horizontalAlignment = Alignment.Start,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Iphone".uppercase(),
                                            fontSize = 18.sp,
                                            color = Color.White,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(500)
                                        )
                                        Text(
                                            text = "08.12.2024",
                                            fontSize = 12.sp,
                                            color = ProgressBarGrey,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(400)
                                        )
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .width(140.dp),
                                        horizontalAlignment = Alignment.Start,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Сумма",
                                            fontSize = 16.sp,
                                            color = ProgressBarGrey,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier.padding(bottom = 7.dp)
                                        )
                                        Text(
                                            text = "200 000 ₽",
                                            fontSize = 18.sp,
                                            style = gradientTextStyle(),
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(bottom = 7.dp)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .width(2.dp)
                                            .height(54.dp)
                                            .background(color = ProgressBarGrey)
                                    ) {

                                    }
                                    Column(
                                        modifier = Modifier
                                            .width(140.dp),
                                        horizontalAlignment = Alignment.End,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Срок",
                                            fontSize = 16.sp,
                                            color = ProgressBarGrey,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier.padding(bottom = 7.dp)
                                        )
                                        Text(
                                            text = "5 лет",
                                            fontSize = 18.sp,
                                            style = gradientTextStyle(),
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(bottom = 7.dp)
                                        )
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .width(270.dp)
                                        .padding(top = 10.dp, bottom = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.trash),
                                            contentDescription = "Trash",
                                            modifier = Modifier
                                                .width(10.7.dp)
                                                .height(12.dp)
                                        )
                                        Text(
                                            text = "Удалить",
                                            fontSize = 12.sp,
                                            color = TextRed,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(400),
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.edit),
                                            contentDescription = "Edit",
                                            modifier = Modifier
                                                .width(12.dp)
                                                .height(12.dp)
                                        )
                                        Text(
                                            text = "Редактировать",
                                            fontSize = 12.sp,
                                            color = DarkGrey,
                                            fontFamily = customFont_roboto_regular,
                                            fontWeight = FontWeight(400),
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



