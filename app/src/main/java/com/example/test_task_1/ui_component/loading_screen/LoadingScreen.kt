package com.example.test_task_1.ui_component.loading_screen

import RedGradientBackground
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_task_1.R
import com.example.test_task_1.ui.theme.Grey
import com.example.test_task_1.ui.theme.TextBlack
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular
import com.example.test_task_1.ui_component.fonts.customFont_sb_sans_display_semibold
import com.example.test_task_1.view_models.LoadingViewModel
import gradientTextStyle

@Composable
fun LoadingScreen(
    onLoadingFinished: () -> Unit,
    loadingViewModel: LoadingViewModel = hiltViewModel()
) {
    val progress by loadingViewModel.progressValue
    val isComplete by loadingViewModel.isLoadingComplete
    val animatedProgress by animateFloatAsState(targetValue = progress)

    LaunchedEffect(Unit) {
        loadingViewModel.simulateLoading()
    }

    LaunchedEffect(isComplete) {
        if (isComplete) {
            onLoadingFinished()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .RedGradientBackground(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .width(325.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
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
                        .size(64.76.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Фин",
                        fontSize = 30.35.sp,
                        style = gradientTextStyle(),
                        fontFamily = customFont_sb_sans_display_semibold,
                    )
                    Text(
                        text = "Старт",
                        fontSize = 30.35.sp,
                        fontFamily = customFont_sb_sans_display_semibold,
                        color = Grey,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                }
                HorizontalProgressBar(progress = animatedProgress)
                Text(
                    text = if (progress >= 0.5f) "Почти готово" else "",
                    fontSize = 18.sp,
                    fontFamily = customFont_roboto_regular,
                    color = TextBlack,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp),
                )
            }
        }
    }
}