package com.estholon.jetpackcomposecatalogo.ui.navigation

sealed class Routes (val route: String){
    object SplashScreen: Routes("splash")

    object SignInScreen : Routes("signin")

    object SignUpScreen : Routes("signup")

    object HomeScreen: Routes("home")

    object TextScreen : Routes("text")

    object RecyclerScreen : Routes("recycler")

}