package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(test: MutableState<String>, title: String) {
    
//    Text(text = "Zvada")



    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = test.value,
        onValueChange = { test.value = it },
        label = { Text(title) },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color("#F6F6F9".toColorInt()),
            textColor = Color("#14142B".toColorInt()),
            focusedLabelColor = Color("#A9ABB7".toColorInt()),
            unfocusedLabelColor = Color("#A9ABB7".toColorInt()),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)


    )

}