package com.example.varprojekt.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.varprojekt.models.QR
import com.example.varprojekt.models.getQR
import com.example.varprojekt.navigation.AppScreens
import com.example.varprojekt.viewmodels.AddQRViewModel
import com.example.varprojekt.widgets.QRRow
import com.example.varprojekt.widgets.RemoveIcon

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: AddQRViewModel,
    qr: List<QR> = getQR()
) {
    Scaffold(topBar = {
        TopAppBar(
            navController = navController,
            addRecipeViewModel = viewModel,
        )
    }){
        MainContent(navController = navController, addQRViewModel = viewModel, qrs = qr)}
    }


@Composable
fun MainContent(
    navController: NavController,
    addQRViewModel: AddQRViewModel,
    qrs: List<QR> = getQR(),
){
    LazyColumn{
        items(qrs){ qr ->
            QRRow(qr = qr,
                onItemClick = {id -> navController.navigate(AppScreens.DetailScreen.name + "/$id")})
            {
                Row {
                    RemoveIcon(qr) { q ->
                        if (addQRViewModel.isadded(q)){
                            addQRViewModel.removeRecipe(q)
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun TopAppBar(
    navController: NavController,
    addRecipeViewModel: AddQRViewModel,
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("VR GAMER") },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = {
                    navController.navigate(route = AppScreens.AddQRScreen.name)
                }) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Scan a QR Code",
                            modifier = Modifier.padding(4.dp)
                        )
                        Text(
                            text = "Scan a QR Code", modifier = Modifier
                                .width(200.dp)
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    )
}