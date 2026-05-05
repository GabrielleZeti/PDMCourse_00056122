package com.example.labo03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable object Home
@Serializable object NameList
@Serializable object Sensors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainNavigation()
            }
        }
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onNavigateToNames = { navController.navigate(NameList) },
                onNavigateToSensors = { navController.navigate(Sensors) }
            )
        }
        composable<NameList> {
            NameListScreen(onBack = { navController.popBackStack() })
        }
        composable<Sensors> {
            SensorInfoScreen(onBack = { navController.popBackStack() })
        }
    }
}