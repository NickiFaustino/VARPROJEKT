package com.example.varprojekt.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.varprojekt.models.QR
import com.example.varprojekt.models.getQR
import com.example.varprojekt.viewmodels.AddQRViewModel
import com.example.varprojekt.widgets.QRRow

fun filterQR(id: String, qr: List<QR>): QR {
    return qr.filter { it.id == id }[0]
}

@Composable
fun DetailScreen(
    navController: NavController = rememberNavController(),
    id: String,
    viewModel: AddQRViewModel
){
    val qr = filterQR(id = id, qr = getQR())

    Scaffold(
        topBar = { SimpleTopAppBar(arrowBackClicked = {navController.popBackStack()}) {
            qr.id?.let { Text(text = it) }
        }}
    ) {
        MainContent(qr = qr, addQRViewModel = viewModel)
    }
}
@Composable
fun MainContent(qr: QR, addQRViewModel: AddQRViewModel){
    var showMenu by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            QRRow(qr = qr){

            }
            AnimatedVisibility(visible = showMenu) {
                Column(
                    modifier = androidx.compose.ui.Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text ="Time:")
                    qr.time?.let { Text(it) }

                }

            }
            Icon(imageVector =
            if (showMenu) Icons.Filled.KeyboardArrowDown
            else Icons.Filled.KeyboardArrowUp,
                contentDescription = "expand",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        showMenu = !showMenu
                    },
                tint = Color.DarkGray)

        }

    }
}

