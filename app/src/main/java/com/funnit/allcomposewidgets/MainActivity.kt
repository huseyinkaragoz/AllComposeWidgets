package com.funnit.allcomposewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.funnit.allcomposewidgets.ui.theme.AllComposeWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllComposeWidgetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageNavigations()
                }
            }
        }
    }
}


@Composable
fun MainPage(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_name))
                }, backgroundColor = colorResource(id = R.color.purple_500)
            )

        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.navigate("Button and Text Field") {

                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.amber),
                        contentColor = colorResource(id = R.color.secondary_text)
                    )
                ) {
                    Text(text = stringResource(id = R.string.button_and_text_field))
                }
            }
        }
    )


}

@Composable
fun PageNavigations() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = stringResource(id = R.string.main_page)
    ) {
        composable("Main Page") {
            MainPage(navController = navController)
        }
        composable(route = "Button and Text Field") {
            ButtonAndTextFieldPage(navController = navController)
        }
    }
}
