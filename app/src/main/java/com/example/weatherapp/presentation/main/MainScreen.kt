package com.example.weatherapp.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainScreen(viewModel: MainViewModel) {

    var cityState by remember {
        mutableStateOf("")
    }

    val res = viewModel.weatherData.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 12.dp,
                top = 16.dp,
                bottom = 8.dp,
                end = 12.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = cityState,
                onValueChange = { cityState = it },
                label = { Text(text = "Search") },
                modifier = Modifier.weight(1f),
                maxLines = 1
            )

            IconButton(onClick = {
                viewModel.getWeatherData(cityState)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search for any location"
                )
            }
        }

        Box(modifier = Modifier.weight(1f)) {

            if (res.data != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                        .verticalScroll(
                            rememberScrollState()
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AsyncImage(
                        model = "https:${res.data.current.condition.icon}".replace("64x64","128x128"),
                        contentDescription = null,
                        modifier = Modifier.size(160.dp)
                    )
                    Text(
                        text = res.data.current.condition.text,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "${res.data.current.temp_c} ° C",
                        style = MaterialTheme.typography.displaySmall
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "${res.data.location.name},${res.data.location.country}",
                            style = MaterialTheme.typography.titleMedium
                        )

                    }
                }
            }

            if (res.error.isNotEmpty()){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = res.error,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (res.isLoading) {
                    CircularProgressIndicator()
                }
            }
        }

    }

}




