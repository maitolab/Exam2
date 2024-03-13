package com.example.exam2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exam2.ui.screen.ScreenDetail
import com.example.exam2.ui.screen.ScreenList

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.List) {
        composable(route = Screens.List) {
            ScreenList {
                navController.navigate(Screens.Detail)
            }
        }
        composable(route = Screens.Detail) {
            ScreenDetail {
                navController.popBackStack()
            }
        }
    }
}
