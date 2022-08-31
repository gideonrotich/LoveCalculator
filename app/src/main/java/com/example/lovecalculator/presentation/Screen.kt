package com.example.lovecalculator.presentation

sealed class Screen(val route: String){
    object CalculatorHomeScreen : Screen("home_screen")
    object CalculatorResultsScreen: Screen("results_screen")
}
