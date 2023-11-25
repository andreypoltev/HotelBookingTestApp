package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController

@Composable
fun CustomBottomBar(text: String, navController: NavHostController, navDestination: String) {

    BottomAppBar(containerColor = Color.White) {
        CustomButton(text = text, navController = navController, navDestination = navDestination)

    }


}

@Composable
fun CustomButton(text: String, navController: NavHostController, navDestination: String) {
    Button(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        onClick = { navController.navigate(navDestination) },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#0D72FF".toColorInt())
        )
    ) {
        Text(
            text = text, fontSize = 16.sp,
            color = Color("#FFFFFF".toColorInt())

        )

    }

}