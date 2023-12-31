package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(test: MutableState<String>, title: String) {

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = test.value,
        shape = RoundedCornerShape(12.dp),
        onValueChange = { test.value = it },
        label = { Text(text = title) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color("#F6F6F9".toColorInt()),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color("#A9ABB7".toColorInt()),
            unfocusedLabelColor = Color("#A9ABB7".toColorInt())
        )
    )


}