package com.example.test_task_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.test_task_1.ui.theme.Test_Task_1Theme
import com.example.test_task_1.ui_component.loading_screen.LoadingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test_Task_1Theme {
                LoadingScreen()
            }
        }
    }
}