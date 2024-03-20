package com.estholon.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estholon.jetpackcomposecatalogo.model.Routes
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

                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") {
                                type = NavType.IntType
                            })) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("name", { defaultValue = "" }))
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name")
                            )
                        }
                    }


                    //ScaffoldExample()
                    /*
                    var myText by rememberSaveable { mutableStateOf("") }
                    val myOptions = getOptions(listOf("Ejemplo 1", "Ejemplo 2", "Ejemplo 3"))


                    var show by rememberSaveable {
                        mutableStateOf(false)
                    }

                    Column(Modifier.fillMaxSize()){

                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                            Button(onClick = { show = true }) {
                                Text(text = "Mostrar diálogo")
                            }
                            // MyDialog(show=show,{ Log.i("Dialog","Confirmado") },{ show = false })
                            MyConfirmationDialog(
                                show = show,
                                onConfirm = { show = false },
                                onDismiss = { show = false }
                            )

                        }
                    }
*/

                }
            }
        }
    }
}

@Composable
fun getOptions(titles:List<String>):List<CheckInfo>{

    return titles.map{
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {myNewStatus -> status = myNewStatus}
        )
    }

}


@Composable
fun MyStateExample() {
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
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier = modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}



@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

    Column(Modifier.fillMaxSize()) {
        TextField(
            value = name,
            onValueChange = { onValueChanged(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun MyTextFieldAdvance() {

    Column(Modifier.fillMaxSize()) {
        var myText by rememberSaveable { mutableStateOf("") }
        TextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains("@")) {
                        it.replace("@", "arroba")
                    } else {
                        it
                    }
            },
            label = { Text(text = "Introduce tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun MyOutlinedTextField() {
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
            border = BorderStroke(12.dp,Color.Blue),
            shape = RoundedCornerShape(0),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text(text = "BUTTON")
        }
        OutlinedButton(onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
                disabledContentColor = Color.Green,
                disabledContainerColor = Color.Cyan
            ),
            border = BorderStroke(12.dp,Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text(text = "OUTLINED BUTTON")
        }
        TextButton(onClick = { }) {
            Text(text = "TEXT BUTTON")
        }
    }
}

@Composable
fun MyImageExample(){
    Column(Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Esto es una prueba")
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Esto es una prueba", alpha = 0.5f)
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Esto es una prueba", modifier = Modifier
            .clip(
                CircleShape
            )
            .border(5.dp, Color.Red, CircleShape))
    }
}

@Composable
fun MyIconExample(){
    Column(Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Rounded.Stars,
            contentDescription = "Icono",
            tint = Color.Red
        )
    }
}

@Composable
fun MyProgressBarExample(){
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        if (showLoading){
            LinearProgressIndicator(color = Color.Red, trackColor = Color.Cyan)
            MySpacerH(50)
            CircularProgressIndicator(color = Color.Green, strokeWidth = 12.dp, trackColor = Color.Blue)
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Activar / Desactivar")
        }
    }
}

@Composable
fun MyCircularProgressIndicator(){
    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(
                onClick = { progressStatus += 0.1f},
                shape = RoundedCornerShape(0),
                modifier = Modifier
                    .padding(12.dp)
                    .width(150.dp)
            ){
                Text(text = "Incrementar")
            }
            Button(
                onClick = { progressStatus -= 0.1f},
                shape = RoundedCornerShape(0),
                modifier = Modifier
                    .padding(12.dp)
                    .width(150.dp)
            ){
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MySwitch(){
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = {state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Magenta.copy(alpha = 0.9f),
            checkedTrackColor = Color.Cyan.copy(alpha = 0.9f),
            uncheckedThumbColor = Color.Red.copy(alpha = 0.9f),
            uncheckedTrackColor = Color.Green.copy(alpha = 0.9f),
            disabledCheckedTrackColor = Color.Yellow.copy(alpha = 0.9f),
            disabledCheckedThumbColor = Color.Gray.copy(alpha = 0.9f),
            disabledUncheckedThumbColor = Color.DarkGray.copy(alpha = 0.9f),
            disabledUncheckedTrackColor = Color.LightGray.copy(alpha = 0.9f)

        ))

}

@Composable
fun MyCheckBox(checkInfo: CheckInfo){
    var state by rememberSaveable {
        mutableStateOf(true)
    }
        Row(
            Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
            ) {
            Checkbox(
                checked = checkInfo.selected,
                onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Black,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.Black,
                    disabledCheckedColor = Color.Black
                )
            )
            MySpacerH(8)
            Text(text = checkInfo.title)

        }

}

@Composable
fun MyTriStateCheckBox(){
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton(name: String, onItemSelected: (String) -> Unit){

    Column(Modifier.fillMaxWidth()){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)){
            RadioButton(selected = name == "Ejemplo 1", onClick = { onItemSelected("Ejemplo 1") })
            Text(text = "Ejemplo 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)){
            RadioButton(selected = name == "Ejemplo 2", onClick = { onItemSelected("Ejemplo 2") })
            Text(text = "Ejemplo 2")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)){
            RadioButton(selected = name == "Ejemplo 3", onClick = { onItemSelected("Ejemplo 3")})
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue,
            contentColor = Color.Green
        ),
        border = BorderStroke(5.dp, Color.Green)
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgedBox(){
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Badge(
                content = { Text("100") },
                containerColor = Color.Blue,
                contentColor = Color.Green
            )
        })  {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Estrella")
    }

}


@Composable
fun MySpacerV(size: Int){
    Spacer(modifier = Modifier.width(size.dp))
}

@Composable
fun MySpacerH(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyDivider(){
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@Composable
fun MyDropDownMenu(){
    var selectedText by rememberSaveable {
        mutableStateOf("")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val options = listOf("Ejemplo 1","Ejemplo 2","Ejemplo 3")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {selectedText = it},
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth())
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            options.forEach{ option ->
                DropdownMenuItem(
                    text = { Text( text = option) },
                    onClick = {
                        expanded = false
                        selectedText = option
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        Column(Modifier.fillMaxSize()) {
            MyCard()
            MyDivider()
            MyBadgedBox()
            MyDropDownMenu()
            BasicSlider()
        }
    }
}