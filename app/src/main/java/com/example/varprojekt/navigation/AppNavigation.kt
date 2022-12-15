package com.example.varprojekt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.varprojekt.models.QR
import com.example.varprojekt.models.createQR
import com.example.varprojekt.screens.AddQRScreen
import com.example.varprojekt.screens.DetailScreen
import com.example.varprojekt.screens.HomeScreen
import com.example.varprojekt.viewmodels.AddQRViewModel

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val addQRViewModel: AddQRViewModel = viewModel()


    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name ){

        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController, addQRViewModel)

        }
        composable(AppScreens.AddQRScreen.name){
            AddQRScreen(navController = navController, addQRViewModel)
        }
        composable(
            route = AppScreens.DetailScreen.name + "/{id}",
            arguments = listOf(navArgument(name = "id"){
                type = NavType.StringType
            })
        ){ navBackStackEntry ->

            navBackStackEntry.arguments?.getString("id")
                ?.let { DetailScreen(navController = navController, id = it, viewModel = addQRViewModel) }

        }
    }

}