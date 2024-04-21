package com.estholon.jetpackcomposecatalogo.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(string: String){
    Column {
        Text(
            text = string,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            textDecoration = TextDecoration.Underline,
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
    }

}