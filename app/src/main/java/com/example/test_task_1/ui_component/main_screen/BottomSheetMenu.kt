package com.example.test_task_1.ui_component.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.test_task_1.constants.EXPENSE
import com.example.test_task_1.constants.INCOME
import com.example.test_task_1.ui_component.main_screen.pager_screens.AddDesireScreen
import com.example.test_task_1.ui_component.main_screen.pager_screens.ExpenseScreen
import com.example.test_task_1.ui_component.main_screen.pager_screens.IncomeScreen
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetMenu(
    isVisible: Boolean,
    isDesire: Boolean,
    onDismissRequest: () -> Unit,
    onSaveTransaction: (String, String, String) -> Unit
) {
    val selectedIndex = remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()
    val options = listOf("Расход", "Доход")

    if (isVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            containerColor = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(top = 20.dp, bottom = 20.dp, start = 30.dp, end = 30.dp)
                    .imePadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (!isDesire) {
                    SegmentedPager(
                        selectedIndex.value,
                        onOptionSelected = { idex ->
                            coroutineScope.launch {
                                selectedIndex.value = idex
                                pagerState.animateScrollToPage(idex)
                            }
                        },
                        options = options
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalPager(
                        count = options.size,
                        state = pagerState,
                        modifier = Modifier.fillMaxSize()
                    ) { page ->
                        when (page) {
                            0 -> ExpenseScreen(
                                onSaveClick = { name, amount ->
                                    onSaveTransaction(name, amount, EXPENSE)
                                }
                            )
                            1 -> IncomeScreen(
                                onSaveClick = { name, amount ->
                                    onSaveTransaction(name, amount, INCOME)
                                }
                            )
                        }
                    }
                } else {
                    AddDesireScreen()
                }

                Spacer(modifier = Modifier.padding(top = 200.dp))
            }
        }
    }
}