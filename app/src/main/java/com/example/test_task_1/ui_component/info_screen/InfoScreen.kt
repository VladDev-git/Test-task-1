package com.example.test_task_1.ui_component.info_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui.theme.Grey
import com.example.test_task_1.ui_component.blog_menu_screen.data.MenuDataItem
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular
import com.example.test_task_1.ui_component.income_expense_screen.SectionNameBar
import com.example.test_task_1.ui_component.main_screen.LogoTopBar

@Composable
fun InfoScreen(
    onBackClick: () -> Unit,
    onNavHomeClick: () -> Unit,
    menuDataItem: MenuDataItem
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomMenu(
                onNavHomeClick = {
                    onNavHomeClick()
                },
                onAddDesireClick = {},
                onMoreMenuClick = {}
            )
        },
        topBar = {
            LogoTopBar()
        },

        ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                SectionNameBar(
                    sectionName = menuDataItem.name,
                    onBackClick = {
                        onBackClick()
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .width(330.dp)
                            .padding(start = 15.dp, end = 15.dp)
                    ) {
                        item {
                            Text(
                                text = menuDataItem.textResources,
                                color = Grey,
                                fontWeight = FontWeight(400),
                                fontSize = 20.sp,
                                fontFamily = customFont_roboto_regular,
                            )
                        }
                    }
                }
            }
        }
    }
}