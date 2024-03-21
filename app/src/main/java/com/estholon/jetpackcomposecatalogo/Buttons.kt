package com.estholon.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
                disabledContentColor = Color.Green,
                disabledContainerColor = Color.Cyan
            ),
            border = BorderStroke(12.dp, Color.Blue),
            shape = RoundedCornerShape(0),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text(text = "BUTTON")
        }
        TextButton(onClick = { }) {
            Text(text = "TEXT BUTTON")
        }
    }
}

// Outlined Button
@Composable
fun MyOutlinedButton(){
    OutlinedButton(onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Blue,
            disabledContentColor = Color.Green,
            disabledContainerColor = Color.Cyan
        ),
        border = BorderStroke(12.dp, Color.Blue),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Text(text = "OUTLINED BUTTON")
    }
}

// Secondary Button
@Composable
fun MyFilledTonalButton(){
    FilledTonalButton(onClick = { }) {
        Text(text = "Holiwi")
    }
}

// Button with elevation
@Composable
fun MyElevatedButton(){
    ElevatedButton(onClick = { }) {
        Text(text = "Holiwi")
    }
}

@Composable
fun MySmallFloatingActionButton(){
    SmallFloatingActionButton(onClick = { }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Composable
fun MyFloatingActionButton(){
    FloatingActionButton(onClick = { }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Composable
fun MyLargeFloatingActionButton(){
    LargeFloatingActionButton(onClick = { }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Composable
fun MyExtendedFloatingActionButton(){
    ExtendedFloatingActionButton(onClick = { },
        icon = {Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Floating action button")},
        text = {Text(text = "Extended")}
    }
}