package com.example.lovecalculator.domain.use_cases

import com.example.lovecalculator.common.Resource
import com.example.lovecalculator.data.remote.dto.toCalculator
import com.example.lovecalculator.domain.models.Calculator
import com.example.lovecalculator.domain.repository.CalculatorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CalculatorUseCase @Inject constructor(
    private val repository: CalculatorRepository
) {
    operator fun invoke(fname:String,sname:String):Flow<Resource<Calculator>> = flow{
        try {
            emit(Resource.Loading())
            val data = repository.getPercentage(fname,sname).toCalculator()
            emit(Resource.Success(data = data))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage ?: "one error"))
        }
    }
}