package com.example.test_task_1.ui_component.main_screen.pager_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.DarkGrey
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun AddDesireScreen(
    onSaveClick: (String, String) -> Unit
) {
    val nameState = remember { mutableStateOf("") }
    val amountState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Название",
            color = DarkGrey,
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            fontFamily = customFont_roboto_regular,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        RoundedCornerTextField(
            text = nameState.value,
            label = "",
            onValueChange = { nameState.value = it }
        )
        Text(
            text = "Сумма",
            color = DarkGrey,
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            fontFamily = customFont_roboto_regular,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp)
        )
        RoundedCornerTextField(
            text = amountState.value,
            label = "₽",
            onValueChange = { amountState.value = it }
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        SaveGradientButton(
            onSaveClick = {
                if (nameState.value.isEmpty() || amountState.value.isEmpty()) return@SaveGradientButton
                onSaveClick(
                    nameState.value,
                    amountState.value
                )
            }
        )
    }
}