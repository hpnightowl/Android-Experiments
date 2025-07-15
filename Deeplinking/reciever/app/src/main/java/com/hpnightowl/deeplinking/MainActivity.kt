package com.hpnightowl.deeplinking

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.hpnightowl.deeplinking.ui.theme.DeeplinkingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeeplinkingTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(onNavigate = {
                            navController.navigate("details/123")
                        })
                    }

                    composable(
                        route = "details/{itemId}",
                        arguments = listOf(navArgument("itemId") {
                            type = NavType.StringType
                        }),
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://example.com/details/{itemId}"
                        })
                    ) { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onNavigate: () -> Unit = {}
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home (Receiver)") }) }
    ) {
        Button(onClick = onNavigate, modifier = Modifier.padding(16.dp)) {
            Text("Navigate to Details/123")
        }
    }
}