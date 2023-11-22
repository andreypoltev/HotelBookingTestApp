package com.andreypoltev.hotelbookingtestapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun HotelScreen(viewModel: HotelViewModel) {

    val state = viewModel.state.collectAsState()

    Text(text = state.value.name.toString())

}