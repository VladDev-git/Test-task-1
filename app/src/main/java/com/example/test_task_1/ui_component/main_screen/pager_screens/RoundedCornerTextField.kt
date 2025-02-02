package com.example.test_task_1.ui_component.main_screen.pager_screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.ProgressBarGrey
import com.example.test_task_1.ui.theme.RedGradientColor2
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun RoundedCornerTextField(
    maxLines: Int = 1,
    maxSymbols: Int = 10,
    numberOnly: Boolean = false,
    singleLine: Boolean = true,
    text: String,
    label: String,
    onValueChange: (String) -> Unit,
    onExpandedClick: () -> Unit
) {
    val regex = if (numberOnly) {
        Regex("^\\d*\\.?\\d*\$")
    } else {
        Regex(".*")
    }

    TextField(
        value = text,
        onValueChange = { newValue ->
            if (newValue.matches(regex) && newValue.length <= maxSymbols) {
                onValueChange(newValue)
            }
        },
        trailingIcon = {
            Text(
                text = label,
                color = ProgressBarGrey,
                fontSize = 18.sp,
                fontWeight = FontWeight(300),
                fontFamily = customFont_roboto_regular,
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (numberOnly) {
                KeyboardType.Number
            } else {
                KeyboardType.Text
            }
        ),
        textStyle = TextStyle(
            lineHeight = 24.sp,
        ),
        maxLines = maxLines,
        singleLine = singleLine,
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = ProgressBarGrey
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = RedGradientColor2,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                onExpandedClick()
            }
    )
}