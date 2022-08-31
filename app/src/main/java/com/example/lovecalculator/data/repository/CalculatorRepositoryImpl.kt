package com.example.lovecalculator.data.repository

import com.example.lovecalculator.data.remote.CalculatorApi
import com.example.lovecalculator.data.remote.dto.CalcResponse
import com.example.lovecalculator.domain.repository.CalculatorRepository
import javax.inject.Inject

class CalculatorRepositoryImpl @Inject constructor(
    private val api:CalculatorApi
) : CalculatorRepository{
    override suspend fun getPercentage(fname: String, sname: String): CalcResponse {
        return api.getPercentage(fname,sname)
    }
}