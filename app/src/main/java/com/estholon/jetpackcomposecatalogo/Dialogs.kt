package com.estholon.jetpackcomposecatalogo

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

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