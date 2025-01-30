package com.example.test_task_1.ui_component.bottom_menu

import RedGradientBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.test_task_1.R
import com.example.test_task_1.ui.theme.DarkGrey

@Composable
fun CustomBottomMenu(
    onNavHomeClick: () -> Unit,
    onAddDesireClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 10.dp, top = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .height(96.dp)
                .background(DarkGrey, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 40.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        onNavHomeClick()
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bottom_menu_home),
                        contentDescription = "Home",
                        modifier = Modifier
                            .width(40.29.dp)
                            .height(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .RedGradientBackground(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = {
                            onAddDesireClick()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = { /* TODO */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bottom_menu_more_menu),
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier
                            .width(41.14.dp)
                            .height(24.dp)
                    )
                }
            }
        }
    }

}
