package com.example.test_task_1.ui_component.main_screen

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.test_task_1.db.Goal
import com.example.test_task_1.db.Transaction
import com.example.test_task_1.ui.theme.BackgroundWhite
import com.example.test_task_1.ui_component.bottom_menu.CustomBottomMenu
import com.example.test_task_1.view_models.FinanceViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(
    onNavHomeClick: () -> Unit,
    onAllTransactionScreenNavigateClick: () -> Unit,
    onMoreMenuClick: () -> Unit,
    financeViewModel: FinanceViewModel = hiltViewModel()
) {
    val localContext = LocalContext.current

    val isBottomSheetVisibleState = remember { mutableStateOf(false) }
    val isDesireBottomSheetVisibleState = remember { mutableStateOf(false) }
    val isEditGoalBottomSheetVisibleState = remember { mutableStateOf(false) }
    val totalIncome by financeViewModel.totalIncome.collectAsStateWithLifecycle()
    val totalExpenses by financeViewModel.totalExpense.collectAsStateWithLifecycle()
    val totalDeposits by financeViewModel.savings.collectAsStateWithLifecycle()
    val goal by financeViewModel.goal.collectAsState()
    val goalMessage by financeViewModel.goalMessage.collectAsState()

    LaunchedEffect(goalMessage) {
        goalMessage?.let {
            Toast.makeText(localContext, it, Toast.LENGTH_SHORT).show()
            financeViewModel.clearGoalMessage()
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomMenu(
                onNavHomeClick = {
                    onNavHomeClick()
                },
                onAddDesireClick = {
                    isDesireBottomSheetVisibleState.value = true
                    isBottomSheetVisibleState.value = true
                },
                onMoreMenuClick = {
                    onMoreMenuClick()
                }
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
                        CardWithText(totalExpenses, "Расходы", 155.dp)
                        CardWithText(totalDeposits, "Накопления", 155.dp)
                    }
                }
                item {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp, start = 22.dp, end = 22.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CardWithText(totalIncome, "Общий доход", 330.dp, 10)
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
                    goal?.let {
                        DepCard(
                            it,
                            onGoalDeleteClick = {
                                financeViewModel.deleteGoal()
                            },
                            onGoalEditClick = {
                                isDesireBottomSheetVisibleState.value = true
                                isBottomSheetVisibleState.value = true
                                isEditGoalBottomSheetVisibleState.value = true
                            }
                        )
                    }
                }
            }
        }
    }
    BottomSheetMenu(isBottomSheetVisibleState.value,
        isDesireBottomSheetVisibleState.value,
        isEditGoalBottomSheetVisibleState.value,
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
        },
        onSaveGoal = { name, amount ->
            isBottomSheetVisibleState.value = false
            financeViewModel.calculateGoalDeadline(amount.toDouble())
            financeViewModel.setGoal(
                Goal(
                    name = name,
                    amount = amount.toDouble(),
                    deadline = financeViewModel.goalDeadline.value
                )
            )
        },
        onEditGoal = { name, amount ->
            isDesireBottomSheetVisibleState.value = false
            isBottomSheetVisibleState.value = false
            isEditGoalBottomSheetVisibleState.value = false
            financeViewModel.calculateGoalDeadline(amount.toDouble())
            financeViewModel.updateGoal(
                Goal(
                    id = goal?.id ?: 0,
                    name = name,
                    amount = amount.toDouble(),
                    deadline = financeViewModel.goalDeadline.value
                )
            )
        }
    )
}




