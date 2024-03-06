package com.estholon.jetpackcomposecatalogo

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estholon.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

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
                    MyBox("Android")
                }
            }
        }
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f).fillMaxSize().background(Color.Cyan), contentAlignment = Alignment.Center){
            Text(text = "Ejemplo 1")
        }
        Row(modifier = Modifier.weight(1f).fillMaxSize()){
                Box(modifier = modifier.weight(1f).fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 2")
                }
                Box(modifier = modifier.weight(1f).fillMaxSize().background(Color.Green), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 3")
                }
        }
        Box(modifier = modifier.weight(1f).fillMaxSize().background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text(text = "Ejemplo 4")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        MyBox("Android")
    }
}