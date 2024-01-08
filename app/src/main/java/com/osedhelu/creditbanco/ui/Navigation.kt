package com.osedhelu.creditbanco.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.osedhelu.creditbanco.ui.Layouts.MainLayout
import com.osedhelu.creditbanco.ui.Screens.MainScreen.MainScreen
import com.osedhelu.creditbanco.ui.Screens.MainScreen.ReportScreen
import com.osedhelu.creditbanco.ui.Screens.anularPago.AnularPagoScreen
import com.osedhelu.creditbanco.ui.Screens.pagoScreen.PagoScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    MainLayout(navController = navController) {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(navController)
            }
            composable("pago") {
                PagoScreen(navController)
            }
            composable("anularPago") {
                AnularPagoScreen(navController)
            }
            composable("resports") {
                ReportScreen(navController = navController)
            }
        }
    }
}
