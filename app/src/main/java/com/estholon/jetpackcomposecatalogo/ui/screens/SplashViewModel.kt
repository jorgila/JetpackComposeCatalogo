package com.estholon.jetpackcomposecatalogo.ui.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

): ViewModel() {

    fun isLogged(): Boolean {

        /* TODO Function isLogged in AuthService */
        return true
    }

}