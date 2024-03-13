package com.estholon.jetpackcomposecatalogo

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialog(
    show: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
){
    if(show){
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {Text(text = "Titulo")},
            text = {Text(text = "Descripción")},
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            },
        )
    }

}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
){

    if(show){
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
            }
        }
    }

}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
){
    if(show){
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitle(title = "Set up backup account")
                MyAccountItem("ejemplo1@gmail.com",R.drawable.avatar)
                MyAccountItem("ejemplo2@gmail.com",R.drawable.avatar)
                MyAccountItem("ejemplo3@gmail.com",R.drawable.avatar)
            }
        }
    }
}

@Composable
fun MyTitle(title: String, modifier: Modifier = Modifier.padding(bottom = 16.dp)){
    Text(
        text = title,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MyAccountItem(email: String, @DrawableRes drawable: Int){
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
){
    if(show){
        Dialog(
            onDismissRequest = { onDismiss()}
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .background(Color.White)
            ){
                MyTitle(title = "Phone ringtone", Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by rememberSaveable { mutableStateOf("") }
                MyRadioButton(name = status) {
                    status = it
                }
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                Row (modifier = Modifier.align(Alignment.End).padding(8.dp) ){
                    TextButton({onDismiss()}){
                        Text(text = "Cancel")
                    }
                    TextButton({onConfirm()}){
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}