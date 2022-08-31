package com.example.lovecalculator.presentation

import com.example.lovecalculator.domain.models.Calculator

data class CalculatorState(
    val isLoading:Boolean = false,
    val calculator:Calculator? = null,
    val error :String = ""
)
