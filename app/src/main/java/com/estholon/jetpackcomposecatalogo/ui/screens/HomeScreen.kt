package com.estholon.jetpackcomposecatalogo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.estholon.jetpackcomposecatalogo.ui.navigation.Routes.*

@Composable
fun HomeScreen(
    navController: NavHostController
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate(TextScreen.route) }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = "Text")
        }
    }

}