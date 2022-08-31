package com.example.lovecalculator.domain.repository

import com.example.lovecalculator.data.remote.dto.CalcResponse

interface CalculatorRepository {
    suspend fun getPercentage(fname:String,sname:String): CalcResponse
}