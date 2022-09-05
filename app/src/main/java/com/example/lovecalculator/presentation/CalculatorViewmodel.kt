package com.example.lovecalculator.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovecalculator.common.Constants
import com.example.lovecalculator.common.Resource
import com.example.lovecalculator.domain.use_cases.CalculatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CalculatorViewmodel @Inject constructor(
    private val calculatorUseCase: CalculatorUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _state = mutableStateOf(CalculatorState())
    val state: State<CalculatorState> = _state


    init {
        savedStateHandle.get<String>(Constants.FNAME_ID)?.let {fname ->
            getPercentage(fname,fname)
        }
    }



     private fun getPercentage(fname:String,sname:String){
        calculatorUseCase(fname,sname).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CalculatorState(calculator = result.data)
                }
                is Resource.Error -> {
                    _state.value = CalculatorState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CalculatorState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}