package com.example.lovecalculator.common

import okhttp3.Interceptor
import okhttp3.Response

class Interceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key", "784ff288e0mshb6844374932e291p142557jsn4b8986ede27b")
            .addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}