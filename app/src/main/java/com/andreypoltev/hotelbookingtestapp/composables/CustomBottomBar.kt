package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomBottomBar(text: String, navController: NavHostController, navDestination: String) {

    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        CustomButton(text = text, navController = navController, navDestination = navDestination)

    }


}