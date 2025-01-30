package com.example.test_task_1.ui_component.income_expense_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.R
import com.example.test_task_1.constants.INCOME
import com.example.test_task_1.db.Transaction
import com.example.test_task_1.ui.theme.Grey
import com.example.test_task_1.ui.theme.TransactionExpenseColor
import com.example.test_task_1.ui.theme.TransactionIncomeColor
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular

@Composable
fun TransactionListItem(
    transaction: Transaction,
    onTransactionDeleteClick: (Transaction) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(

        ) {
            Image(
                painter = painterResource(id = R.drawable.trash),
                contentDescription = null,
                modifier = Modifier
                    .width(20.17.dp)
                    .height(22.dp)
                    .clickable(
                        onClick = {
                            onTransactionDeleteClick(transaction)
                        }
                    )
            )
            Text(
                text = transaction.name,
                fontSize = 18.sp,
                color = Grey,
                fontWeight = FontWeight(400),
                fontFamily = customFont_roboto_regular,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Text(
            text = if (transaction.type == INCOME) "+${transaction.amount}" else "-${transaction.amount}",
            fontSize = 18.sp,
            color = if (transaction.type == INCOME) TransactionIncomeColor else TransactionExpenseColor,
            fontWeight = FontWeight(400),
            fontFamily = customFont_roboto_regular
        )
    }
}