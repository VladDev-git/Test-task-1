package com.example.test_task_1.ui_component.blog_menu_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_task_1.ui.theme.Grey
import com.example.test_task_1.ui_component.blog_menu_screen.data.MenuDataItem
import com.example.test_task_1.ui_component.fonts.customFont_roboto_regular
import gradientTextStyle

@Composable
fun MenuListItem(
    menuItem: MenuDataItem,
    onMenuItemClick: (MenuDataItem) -> Unit
) {
    Box(
        modifier = Modifier
            .width(330.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(Color.White)
    ) {
        Button(
            onClick = {
                onMenuItemClick(menuItem)
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${menuItem.number}.",
                        style = gradientTextStyle(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = customFont_roboto_regular,
                    )
                    Text(
                        text = menuItem.name,
                        color = Grey,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = customFont_roboto_regular,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

        }
    }

}




