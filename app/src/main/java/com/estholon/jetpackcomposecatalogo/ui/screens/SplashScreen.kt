package com.estholon.jetpackcomposecatalogo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.estholon.jetpackcomposecatalogo.R
import com.estholon.jetpackcomposecatalogo.ui.navigation.Routes.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel(),
    navController: NavHostController
){

    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()

        if (splashViewModel.isLogged()) {
            navController.navigate(HomeScreen.route)
        } else {
            navController.navigate(SignInScreen.route)
        }

    }


    // Splash Layout

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.img_compose_logo),
            contentDescription = "Compose Catalog",
            modifier = Modifier.fillMaxWidth()
        )
    }
}