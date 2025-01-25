package com.example.test_task_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_task_1.ui.theme.Test_Task_1Theme
import com.example.test_task_1.ui_component.loading_screen.LoadingScreen
import com.example.test_task_1.ui_component.loading_screen.data.LoadingScreenObject
import com.example.test_task_1.ui_component.main_screen.MainScreen
import com.example.test_task_1.ui_component.main_screen.data.MainScreenObject
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Test_Task_1Theme {
                val systemUiController = rememberSystemUiController()
                val darkTheme = true

                if (darkTheme) {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = false
                    )
                } else {
                    systemUiController.setSystemBarsColor(
                        color = Color.White,
                        darkIcons = true
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = MainScreenObject
                ) {
                    composable<LoadingScreenObject> {
                        LoadingScreen()
                    }
                    composable<MainScreenObject> {
                        MainScreen()
                    }
                }
            }
        }
    }
}