package com.estholon.jetpackcomposecatalogo.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicSlider(){

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        var sliderPosition by rememberSaveable {
            mutableStateOf(0f)
        }
        Slider(value =sliderPosition,onValueChange={sliderPosition = it}, modifier = Modifier.padding(30.dp))
        Text(text = sliderPosition.toString())

    }

}

@Composable
fun AdvanceSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        var sliderPosition by rememberSaveable {
            mutableStateOf(0f)
        }
        var completeValue by rememberSaveable {
            mutableStateOf("")
        }
        Slider(
            value =sliderPosition,
            onValueChange={sliderPosition = it},
            valueRange = 0f..10f,
            steps = 9,
            modifier = Modifier.padding(20.dp))
        Text(text = sliderPosition.toString())

    }
}