package com.funnit.allcomposewidgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ButtonAndTextFieldPage(navController: NavController) {

    val textField = remember {
        mutableStateOf("")
    }
    val receivedText = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.button_and_text_field))
                }, backgroundColor = colorResource(id = R.color.purple_500)
            )

        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Received Text",
                        color = colorResource(
                            id = R.color.dark_deep_orange
                        ),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "${receivedText.value}",
                        color = colorResource(
                            id = R.color.black
                        ),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                TextField(
                    value = textField.value,
                    onValueChange = { textField.value = it },
                    label = {
                        Text(text = stringResource(id = R.string.write_text))
                    }
                )

                Button(
                    onClick = {
                        receivedText.value = textField.value
                        textField.value=""
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.purple_700),
                        contentColor = colorResource(id = R.color.white)
                    )
                ) {
                    Text(text = stringResource(id = R.string.read_text))
                }

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.dark_deep_orange),
                        contentColor = colorResource(id = R.color.white)
                    )
                ) {
                    Text(text = stringResource(id = R.string.main_page))
                }

            }
        })

}