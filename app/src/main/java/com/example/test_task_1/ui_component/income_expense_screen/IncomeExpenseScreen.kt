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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    onNavHomeClick: () -> Unit,
    onBackClick: () -> Unit,
    financeViewModel: FinanceViewModel = hiltViewModel()
) {
    val transactionsList by financeViewModel.transactions.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomMenu(
                onNavHomeClick = {
                    onNavHomeClick()
                },
                onAddDesireClick = {}
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
                    "Доходы и расходы",
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
                        items(transactionsList, key = {it.id}) { transaction ->
                            TransactionListItem(
                                transaction = transaction,
                                onTransactionDeleteClick = { transactionItem ->
                                    financeViewModel.deleteTransaction(transactionItem)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}