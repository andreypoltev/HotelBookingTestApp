package com.andreypoltev.hotelbookingtestapp.screens.room

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun RoomScreen(viewModel: RoomViewModel) {

    val zvd = listOf(1,3,4)

    val state = viewModel.state.collectAsState()
    
    LazyColumn {
        items(state.value) {
            Text(text = it.name.toString())

        }
    }
    



}