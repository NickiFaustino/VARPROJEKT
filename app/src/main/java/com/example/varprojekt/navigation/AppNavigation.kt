package com.example.varprojekt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        }
        composable(AppScreens.DetailScreen.name){

        }
    }

}