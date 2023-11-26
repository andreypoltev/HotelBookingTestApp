package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(text: String, navController: NavHostController) {


    CenterAlignedTopAppBar(title = {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color("#000000".toColorInt()),
            textAlign = TextAlign.Center,
        )


    }, navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {

            Icon(
                painter = painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.arrow_back),
                contentDescription = "Go Back Button", Modifier.size(32.dp),
                tint = Color.Black
            )


        }
    },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White))


}