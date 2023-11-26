package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun CustomButton(text: String, navController: NavHostController, navDestination: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(horizontal = 16.dp, vertical = 12.dp),
        onClick = { navController.navigate(navDestination) },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#0D72FF".toColorInt())
        )
    ) {
        Text(

            text = text, fontSize = 16.sp,
            color = Color("#FFFFFF".toColorInt()),
            modifier = Modifier.padding(8.dp)
//            style = MaterialTheme.typography.titleMedium,

        )

    }

}