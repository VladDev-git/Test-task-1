package com.example.test_task_1.ui_component.income_expense_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.ui_component.main_screen.LogoTopBar
import com.example.test_task_1.view_models.FinanceViewModel

@Composable
fun IncomeExpenseScreen(
    financeViewModel: FinanceViewModel = hiltViewModel()
) {
    val transactionsList = remember {
        mutableStateOf(financeViewModel.transactions)
    }

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                SectionNameBar("Доходы и расходы")
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .width(330.dp)
                    ) {
                        items(transactionsList.value.value) { transaction ->
                            TransactionListItem(transaction = transaction)
                        }
                    }
                }
            }

        }
    }
}