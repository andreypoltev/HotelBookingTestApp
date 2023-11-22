package com.andreypoltev.hotelbookingtestapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun RoomScreen(viewModel: RoomViewModel) {

    val state = viewModel.state.collectAsState()
    
    LazyColumn {
        items(state.value.rooms) {

        }
    }
    
    Text(text = state.value.rooms.)
    
    


}