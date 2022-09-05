package com.example.lovecalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.example.lovecalculator.domain.models.Calculator
import com.example.lovecalculator.ui.theme.Purple700

@Composable
fun CalculatorResultsScreen(
    viewModel: CalculatorViewmodel = hiltViewModel()

){
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        state.calculator?.let { calculator ->

           LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
               item {

                   Column(
                       modifier = Modifier.padding(20.dp).fillMaxSize(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       VoteAverageRatingIndicator(
                           modifier = Modifier
                               .fillMaxWidth(0.17f),
                           percentage = calculator.percentage!!.toFloat()
                       )
                       Spacer(modifier = Modifier.height(20.dp))
                       Text(
                           text = "${calculator.result}",
                           style = TextStyle(
                               fontSize = 26.sp,
                               color = Purple700
                           ),
                           overflow = TextOverflow.Ellipsis,

                           )
                       if (state.error.isNotBlank()){
                           Text(
                               text = state.error,
                               color = MaterialTheme.colors.error,
                               textAlign = TextAlign.Center,
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(horizontal = 20.dp)

                           )
                       }
                       if (state.isLoading){
                           CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
                       }
                   }


               }
           }

        }


    }

}