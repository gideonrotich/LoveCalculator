package com.example.lovecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lovecalculator.presentation.CalculatorHomeScreen
import com.example.lovecalculator.presentation.CalculatorResultsScreen
import com.example.lovecalculator.presentation.Screen
import com.example.lovecalculator.ui.theme.LoveCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoveCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CalculatorHomeScreen.route
                    ){
                        composable(
                            route = Screen.CalculatorHomeScreen.route
                        ){
                            CalculatorHomeScreen(navController)
                        }
                        composable(
                            route = Screen.CalculatorResultsScreen.route + "/{fname}" + "/{sname}"
                        ){
                            CalculatorResultsScreen()
                        }
                    }

                }
            }
        }
    }
}

