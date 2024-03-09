package com.estholon.jetpackcomposecatalogo

data class CheckInfo (
    val title: String,
    var selected: Boolean,
    var onCheckedChange: (Boolean) -> Unit
)