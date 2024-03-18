package com.estholon.jetpackcomposecatalogo

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ScaffoldExample(){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            MyTopAppBar({ coroutineScope.launch {
                snackbarHostState.showSnackbar("Has pulsado $it")
            } }) },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(
                        snackbarData = it,
                        containerColor = Color.LightGray,
                        contentColor = Color.Blue
                    )
                }
            )
        },
    ) {
    }

}

@ExperimentalMaterial3Api
@Composable
fun MyTopAppBar(onClickIcon:(String)->Unit){
    TopAppBar(title = { Text(text = "Toolbar") }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Red,
        titleContentColor = Color.White,
        navigationIconContentColor = Color.White,
        actionIconContentColor = Color.White
    ),
    navigationIcon = { IconButton(onClick = { onClickIcon("Atrás")}){
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
    } },
        actions = {
            IconButton(onClick = {onClickIcon("Buscar") }){
                Icon(imageVector = Icons.Filled.Search, contentDescription = "back")
            }
            IconButton(onClick = { onClickIcon("Peligro")}){
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "back")
            }
        })
}