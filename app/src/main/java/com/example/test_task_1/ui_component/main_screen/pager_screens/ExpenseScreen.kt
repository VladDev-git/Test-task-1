package com.example.test_task_1.ui_component.main_screen.pager_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.DarkGrey
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun ExpenseScreen(

) {
    val nameState = remember { mutableStateOf("") }
    val amountState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Название",
            color = DarkGrey,
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            fontFamily = customFont_roboto_regular
        )
        RoundedCornerTextField(
            text = nameState.value,
            label = "Введите название",
            onValueChange = { nameState.value = it }
        )
    }

}