package com.example.test_task_1.ui_component.blog_menu_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.test_task_1.R
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui_component.blog_menu_screen.data.MenuDataItem
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.ui_component.income_expense_screen.SectionNameBar
import com.example.test_task_1.ui_component.main_screen.LogoTopBar

@Composable
fun BlogMenuScreen(
    onBackClick: () -> Unit,
    onNavHomeClick: () -> Unit,
    onMenuClick: (MenuDataItem) -> Unit
) {
    var number = 1
    val menuItemsList: List<MenuDataItem> = listOf(
        MenuDataItem(
            name = "Инвестиции в акции",
            textResources = stringResource(id = R.string.action_text),
            1
        ),
        MenuDataItem(
            name = "Инвестиции в облигации",
            textResources = stringResource(id = R.string.obligation_text),
            2
        ),
        MenuDataItem(
            name = "Инвестиции в недвижимость",
            textResources = stringResource(id = R.string.real_estate_text),
            3
        ),
        MenuDataItem(
            name = "Инвестиции в золото и драгоценные металлы",
            textResources = stringResource(id = R.string.gold_and_precious_metals_text),
            4
        ),
        MenuDataItem(
            name = "Инвестиции в криптовалюты",
            textResources = stringResource(id = R.string.cryptocurrency_text),
            5
        ),
    )

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
                    "Блог",
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
                        items(menuItemsList) { item ->
                            MenuListItem(
                                menuItem = item,
                                onMenuItemClick = { menuItem ->
                                    onMenuClick(menuItem)
                                }
                            )
                            Spacer(modifier = Modifier.padding(10.dp))
                        }
                    }
                }
            }
        }
    }
}