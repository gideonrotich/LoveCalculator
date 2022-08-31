package com.example.lovecalculator.data.remote.dto

import com.example.lovecalculator.domain.models.Calculator

data class CalcResponse(
    val  percentage:String,
    val result:String
)

fun CalcResponse.toCalculator(): Calculator{
    return Calculator(
        percentage = percentage,
        result = result
    )
}
