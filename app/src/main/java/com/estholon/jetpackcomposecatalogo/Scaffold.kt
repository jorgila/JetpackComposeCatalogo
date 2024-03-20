package com.estholon.jetpackcomposecatalogo

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
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
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ScaffoldExample(){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer() { coroutineScope.launch { drawerState.apply{ close() } } }
            }
        },
    ){
        Scaffold(
            topBar = {
                MyTopAppBar(onClickIcon = { coroutineScope.launch {
                    snackbarHostState.showSnackbar("Has pulsado $it")
                } }, onClickDrawer = {
                    coroutineScope.launch { drawerState.apply { if (isClosed) open() else close() } }
                })},
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
            },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center,
        ) {
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun MyTopAppBar(onClickIcon:(String)->Unit, onClickDrawer: ()-> Unit){
    TopAppBar(title = { Text(text = "Toolbar") }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Red,
        titleContentColor = Color.White,
        navigationIconContentColor = Color.White,
        actionIconContentColor = Color.White
    ),
    navigationIcon = { IconButton(onClick = { onClickDrawer() }){
        Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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



@Composable
fun MyFAB(){
    FloatingActionButton(
        onClick = { },
        contentColor = Color.Black,
        containerColor = Color.Yellow,
        shape = CircleShape,
        modifier = Modifier
            .offset(y = 50.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "add"
        )

    }
}

@Composable
fun MyNavigationDrawer(onCloseDrawer: () -> Unit) {


    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Primera opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })
        Text(text = "Segunda opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })
        Text(text = "Tercera opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })
        Text(text = "Cuarta opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })

    }
}