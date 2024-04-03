package com.example.weatherapp.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(
    cityState: MutableState<String>,
    res: WeatherDataState
) {
    Column(modifier = Modifier
        .fillMaxSize()){
        TextField(
            value = cityState.value,
            onValueChange = { cityState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 36.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            
        )
        Spacer(modifier = Modifier.size(16.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)){

            if (res.isLoading){
                CircularProgressBar()
            }

            if (res.error.isNotBlank()){
                ErrorMessage()
            }

            res.data?.let {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = it.location.name)
                        Text(text = it.current.condition.text)
                        Text(text = it.current.temp_c.toString())
                    }
                }
            }

        }
    }
}

@Composable
fun CircularProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "No matching data found")
    }
}