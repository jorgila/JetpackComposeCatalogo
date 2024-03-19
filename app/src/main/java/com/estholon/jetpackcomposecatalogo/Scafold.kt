package com.estholon.jetpackcomposecatalogo

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
        bottomBar = {
            MyBottomNavigation()
        }
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

@Composable
fun MyBottomNavigation(){
    var index by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(containerColor = Color.Red, contentColor = Color.White, ) {
        NavigationBarItem(selected = index == 0, onClick = { index = 0}, icon = { Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
        ) }, label = { Text(text = "Home")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Yellow,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.LightGray,
                disabledTextColor = Color.LightGray,
            )
        )
        NavigationBarItem(selected = index == 1, onClick = { index = 1}, icon = { Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "favorite"
        ) }, label = { Text(text = "Favorite")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Yellow,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.LightGray,
                disabledTextColor = Color.LightGray,
            ))
        NavigationBarItem(selected = index == 2, onClick = { index = 2}, icon = { Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "person"
        ) }, label = { Text(text = "Person")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Yellow,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.LightGray,
                disabledTextColor = Color.LightGray,
            ))
    }
}