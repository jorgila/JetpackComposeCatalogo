package com.estholon.jetpackcomposecatalogo.model

data class CheckInfo (
    val title: String,
    var selected: Boolean,
    var onCheckedChange: (Boolean) -> Unit
)