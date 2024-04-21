package com.estholon.jetpackcomposecatalogo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estholon.jetpackcomposecatalogo.ui.navigation.Routes.*

@Composable
fun HomeScreen(
    navController: NavHostController
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "COMPONENTS",
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = { navController.navigate(TextScreen.route) },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = "Text")
            }

            Button(
                onClick = { navController.navigate(RecyclerScreen.route) },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = "Recycler")
            }
        }
    }
}