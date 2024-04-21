package com.estholon.jetpackcomposecatalogo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.estholon.jetpackcomposecatalogo.ui.navigation.Routes
import com.estholon.jetpackcomposecatalogo.ui.screens.components.Title

@Composable
fun TextScreen(
    navController: NavHostController
) {

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
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = "TEXT",
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Title("FontSize")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "fontSize = 8.sp", fontSize = 8.sp)
                    Text(text = "fontSize = 12.sp", fontSize = 12.sp)
                    Text(text = "fontSize = 16.sp", fontSize = 16.sp)
                    Text(text = "fontSize = 20.sp", fontSize = 20.sp)
                    Text(text = "fontSize = 24.sp", fontSize = 24.sp)
                    Text(text = "fontSize = 24.sp", fontSize = 28.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title("FontStyle")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "fontStyle = FontStyle.Normal", fontStyle = FontStyle.Normal)
                    Text(text = "fontStyle = FontStyle.Italic", fontStyle = FontStyle.Italic)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title("FontWeight")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "fontWeight = FontWeight.ExtraBold",
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "fontWeight = FontWeight.SemiBold",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "fontWeight = FontWeight.Bold", fontWeight = FontWeight.Bold)
                    Text(text = "fontWeight = FontWeight.Black", fontWeight = FontWeight.Black)
                    Text(text = "fontWeight = FontWeight.Normal", fontWeight = FontWeight.Normal)
                    Text(text = "fontWeight = FontWeight.Thin", fontWeight = FontWeight.Thin)
                    Text(text = "fontWeight = FontWeight.Light", fontWeight = FontWeight.Light)
                    Text(
                        text = "fontWeight = FontWeight.ExtraLight",
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title("FontFamily")
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp),
                    shape = RectangleShape
                ) {
                    Text(text = "fontFamily = FontFamily.Default", fontFamily = FontFamily.Default)
                    Text(text = "fontFamily = FontFamily.Cursive", fontFamily = FontFamily.Cursive)
                    Text(text = "fontFamily = FontFamily.Serif", fontFamily = FontFamily.Serif)
                    Text(
                        text = "fontFamily = FontFamily.SansSerif",
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "fontFamily = FontFamily.Monospace",
                        fontFamily = FontFamily.Monospace
                    )
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "LetterSpacing")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "letterSpacing = TextUnit.Unspecified",
                        letterSpacing = TextUnit.Unspecified
                    )
                    Text(
                        text = "letterSpacing = TextUnit(1f, TextUnitType.Sp)",
                        letterSpacing = TextUnit(1f, TextUnitType.Sp)
                    )
                    Text(
                        text = "letterSpacing = TextUnit(2f, TextUnitType.Sp)",
                        letterSpacing = TextUnit(2f, TextUnitType.Sp)
                    )
                    Text(
                        text = "letterSpacing = TextUnit(3f, TextUnitType.Sp)",
                        letterSpacing = TextUnit(3f, TextUnitType.Sp)
                    )
                    Text(
                        text = "letterSpacing = TextUnit(4f, TextUnitType.Sp)",
                        letterSpacing = TextUnit(4f, TextUnitType.Sp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "TextDecoration")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "textDecoration = TextDecoration.None",
                        textDecoration = TextDecoration.None
                    )
                    Text(
                        text = "textDecoration = TextDecoration.Underline",
                        textDecoration = TextDecoration.Underline
                    )
                    Text(
                        text = "textDecoration = TextDecoration.LineThrough",
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(
                        text = "textDecoration = TextDecoration.combine(listOf(TextDecoration.LineThrough,TextDecoration.Underline))",
                        textDecoration = TextDecoration.combine(
                            listOf(
                                TextDecoration.LineThrough,
                                TextDecoration.Underline
                            )
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "TextAlign")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "textAlign = TextAlign.Right",
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "textAlign = TextAlign.End",
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "textAlign = TextAlign.Center",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "textAlign = TextAlign.Start",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "textAlign = TextAlign.Left",
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "textAlign = TextAlign.Justify",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "LineHeight")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Esto es un texto con lineHeight = TextUnit.Unspecified.Esto es un texto con lineHeight = TextUnit.Unspecified",
                        lineHeight = TextUnit.Unspecified
                    )
                    Text(
                        text = "Esto es un texto con lineHeight = TextUnit(1f, TextUnitType.Sp). Esto es un texto con lineHeight = TextUnit(1f, TextUnitType.Sp)",
                        lineHeight = TextUnit(10f, TextUnitType.Sp)
                    )
                    Text(
                        text = "Esto es un texto con lineHeight = TextUnit(2f, TextUnitType.Sp). Esto es un texto con lineHeight = TextUnit(2f, TextUnitType.Sp)",
                        lineHeight = TextUnit(20f, TextUnitType.Sp)
                    )
                    Text(
                        text = "Esto es un texto con lineHeight = TextUnit(3f, TextUnitType.Sp). Esto es un texto con lineHeight = TextUnit(3f, TextUnitType.Sp)",
                        lineHeight = TextUnit(30f, TextUnitType.Sp)
                    )
                    Text(
                        text = "Esto es un texto con lineHeight = TextUnit(4f, TextUnitType.Sp). Esto es un texto con lineHeight = TextUnit(4f, TextUnitType.Sp)",
                        lineHeight = TextUnit(40f, TextUnitType.Sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "Overflow")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "overflow = TextOverflow.Clip. overflow = TextOverflow.Clip",
                        overflow = TextOverflow.Clip,
                        maxLines = 1
                    )
                    Text(
                        text = "overflow = TextOverflow.Ellipsis. overflow = TextOverflow.Ellipsis",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        text = "overflow = TextOverflow.Visible. overflow = TextOverflow.Visible",
                        overflow = TextOverflow.Visible,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "MaxLines")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "maxLines = 1", maxLines = 1)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "MinLines")
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp),
                    shape = RectangleShape
                ) {
                    Text(text = "minLines = 1", minLines = 1)
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Title(string = "Style")
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp),
                    shape = RectangleShape
                ) {
                    Text(text = "style = TextStyle()", style = TextStyle(fontFamily = FontFamily.Default))
                }

            }
        }

    }
}
