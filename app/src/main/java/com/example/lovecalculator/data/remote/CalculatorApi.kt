package com.example.lovecalculator.data.remote

import com.example.lovecalculator.common.Constants
import com.example.lovecalculator.data.remote.dto.CalcResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CalculatorApi {

    @GET(Constants.GET_PERCENTAGE)
    suspend fun getPercentage(@Query("fname")fname:String,@Query("sname")sname:String):CalcResponse
}