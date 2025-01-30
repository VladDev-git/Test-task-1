package com.example.test_task_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_task_1.ui.theme.Test_Task_1Theme
import com.example.test_task_1.ui_component.blog_menu_screen.BlogMenuScreen
import com.example.test_task_1.ui_component.blog_menu_screen.data.BlogMenuScreenObject
import com.example.test_task_1.ui_component.blog_menu_screen.data.MenuDataItem
import com.example.test_task_1.ui_component.income_expense_screen.IncomeExpenseScreen
import com.example.test_task_1.ui_component.income_expense_screen.data.IncomeExpenseScreenObject
import com.example.test_task_1.ui_component.info_screen.InfoScreen
import com.example.test_task_1.ui_component.info_screen.data.InfoScreenObject
import com.example.test_task_1.ui_component.loading_screen.LoadingScreen
import com.example.test_task_1.ui_component.loading_screen.data.LoadingScreenObject
import com.example.test_task_1.ui_component.main_screen.MainScreen
import com.example.test_task_1.ui_component.main_screen.data.MainScreenObject
import com.example.test_task_1.view_models.LoadingViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val loadingViewModel: LoadingViewModel = hiltViewModel()
            var menuItem: MenuDataItem? = null

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
                    startDestination = LoadingScreenObject
                ) {
                    composable<LoadingScreenObject> {
                        LoadingScreen(
                            onLoadingFinished = {
                                navController.navigate(MainScreenObject)
                            }
                        )
                    }
                    composable<MainScreenObject> {
                        MainScreen(
                            onNavHomeClick = {

                            },
                            onAllTransactionScreenNavigateClick = {
                                navController.navigate(IncomeExpenseScreenObject)
                            },
                            onMoreMenuClick = {
                                navController.navigate(BlogMenuScreenObject)
                            }
                        )
                    }
                    composable<IncomeExpenseScreenObject> {
                        IncomeExpenseScreen(
                            onNavHomeClick = {
                                navController.navigate(MainScreenObject)
                            },
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onMoreMenuClick = {
                                navController.navigate(BlogMenuScreenObject)
                            }
                        )
                    }
                    composable<BlogMenuScreenObject> {
                        BlogMenuScreen(
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onNavHomeClick = {
                                navController.navigate(MainScreenObject)
                            },
                            onMenuClick = { menuDataItem ->
                                menuItem = menuDataItem
                                navController.navigate(InfoScreenObject)
                            }
                        )
                    }
                    composable<InfoScreenObject> {
                        InfoScreen(
                            menuDataItem = menuItem?: return@composable,
                            onNavHomeClick = {
                                navController.navigate(MainScreenObject)
                            },
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}