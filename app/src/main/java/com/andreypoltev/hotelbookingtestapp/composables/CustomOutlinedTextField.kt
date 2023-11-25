package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomOutlinedTextField(title: String, text: String, it: String) {
//
//    var name by remember { mutableStateOf(it.name) }
//
//
//    OutlinedTextField(
//        modifier = Modifier.fillMaxWidth(),
//        value = text,
//        onValueChange = { text = it },
//        label = { Text(title) },
//        singleLine = true,
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            containerColor = Color("#F6F6F9".toColorInt()),
//            textColor = Color("#14142B".toColorInt()),
//            focusedLabelColor = Color("#A9ABB7".toColorInt()),
//            unfocusedLabelColor = Color("#A9ABB7".toColorInt()),
//            focusedBorderColor = Color.Transparent,
//            unfocusedBorderColor = Color.Transparent
//        ),
//        shape = RoundedCornerShape(12.dp)
//
//
//    )
//
//}