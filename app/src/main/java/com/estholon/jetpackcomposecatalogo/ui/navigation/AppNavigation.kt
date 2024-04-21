package com.estholon.jetpackcomposecatalogo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.estholon.jetpackcomposecatalogo.ui.navigation.Routes.*
import com.estholon.jetpackcomposecatalogo.ui.screens.HomeScreen
import com.estholon.jetpackcomposecatalogo.ui.screens.RecyclerScreen
import com.estholon.jetpackcomposecatalogo.ui.screens.SignInScreen
import com.estholon.jetpackcomposecatalogo.ui.screens.SignUpScreen
import com.estholon.jetpackcomposecatalogo.ui.screens.SplashScreen
import com.estholon.jetpackcomposecatalogo.ui.screens.TextScreen


@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashScreen.route
    ){
        composable(SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(SignInScreen.route){
            SignInScreen(navController = navController)
        }
        composable(SignUpScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(TextScreen.route){
            TextScreen(navController = navController)
        }
        composable(RecyclerScreen.route){
            RecyclerScreen(navController = navController)
        }
    }
}
