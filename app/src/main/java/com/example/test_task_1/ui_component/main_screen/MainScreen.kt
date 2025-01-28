package com.example.test_task_1.ui_component.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_task_1.db.Transaction
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.view_models.FinanceViewModel

@Composable
fun MainScreen(
    onAllTransactionScreenNavigateClick: () -> Unit,
    financeViewModel: FinanceViewModel = hiltViewModel()
) {
    val isBottomSheetVisibleState = remember { mutableStateOf(false) }
    val isDesireBottomSheetVisibleState = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomMenu()
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
                    AddProfAndPayButton() { visibleValue ->
                        isBottomSheetVisibleState.value = visibleValue
                        isDesireBottomSheetVisibleState.value = false
                    }
                }
                item {
                    MoreContentButton(
                        onAllTransactionScreenNavigateClick = {
                            onAllTransactionScreenNavigateClick()
                        }
                    )
                }
                item {
                    DreamsListButton()
                }
                item {
                    DepCard()
                }
            }
        }
    }
    BottomSheetMenu(isBottomSheetVisibleState.value,
        isDesireBottomSheetVisibleState.value,
        onDismissRequest = {
            isBottomSheetVisibleState.value = false
        },
        onSaveTransaction = { name, amount, type ->
            isBottomSheetVisibleState.value = false
            financeViewModel.addTransaction(
                Transaction(
                    name = name,
                    amount = amount.toDouble(),
                    type = type
                )
            )
        }
    )
}




