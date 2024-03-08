package com.estholon.jetpackcomposecatalogo

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estholon.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyOutlinedTextField()
                }
            }
        }
    }
}

@Composable
fun MyStateExample(){
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
            .background(Color.Cyan), contentAlignment = Alignment.Center){
            Text(text = "Ejemplo 1")
        }
        Row(modifier = Modifier
            .weight(1f)
            .fillMaxSize()){
                Box(modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 2")
                }
                Box(modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 3")
                }
        }
        Box(modifier = modifier
            .weight(1f)
            .fillMaxSize()
            .background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MyText(){
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.LineThrough, TextDecoration.Underline)
        )))
        Text(text = "Esto es una prueba", fontSize = 30.sp)
    }
}

@Composable
fun MyTextField(){

    Column(Modifier.fillMaxSize()) {
        var myText by rememberSaveable { mutableStateOf("") }
        TextField(value = myText, onValueChange = {myText = it}, modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun MyTextFieldAdvance(){

    Column(Modifier.fillMaxSize()) {
        var myText by rememberSaveable { mutableStateOf("") }
        TextField(
            value = myText,
            onValueChange = {myText =
                if(it.contains("@")){
                    it.replace("@","arroba")
                    } else {
                    it
                    }
                            },
            label = { Text(text="Introduce tu nombre") },
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun MyOutlinedTextField(){
    Column(Modifier.fillMaxSize()) {
        var myText by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            label = { Text(text = "Introduce tu nombre") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Red,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedLabelColor = Color.Green
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        MyOutlinedTextField()
    }
}