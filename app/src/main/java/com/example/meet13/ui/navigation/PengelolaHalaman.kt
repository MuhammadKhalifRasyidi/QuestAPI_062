package com.example.meet13.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.meet13.ui.view.DestinasiDetail
import com.example.meet13.ui.view.DestinasiEntry
import com.example.meet13.ui.view.DestinasiHome
import com.example.meet13.ui.view.DestinasiUpdate
import com.example.meet13.ui.view.DetailScreen
import com.example.meet13.ui.view.EntryMhsScreen
import com.example.meet13.ui.view.HomeScreen
import com.example.meet13.ui.view.UpdateScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                    navController.navigate("${DestinasiDetail.route}/$it")
                })
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true
                    }
                }
            })
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.NIM) {
                type = NavType.StringType
            })) {
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailScreen(onBackClick = {
                    navController.popBackStack()
                }, onEditClick = {
                    navController.navigate("${DestinasiEntry.route}/$it")
                }, nim = nim
                )
            }
        }
        composable(
            route = DestinasiUpdate.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.NIM) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiUpdate.NIM)
            nim?.let {
                UpdateScreen(
                    onBack = { navController.popBackStack() },
                    onNavigate = {
                        navController.navigate(DestinasiHome.route) {
                            popUpTo(DestinasiHome.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier,
                )
            }
        }
    }
}