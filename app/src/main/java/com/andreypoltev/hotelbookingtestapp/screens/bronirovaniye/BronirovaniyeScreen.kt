package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.andreypoltev.hotelbookingtestapp.R
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BronirovaniyeScreen() {

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Бронирование",
                fontSize = 18.sp,
                color = Color("#000000".toColorInt())
            )
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Go Back", Modifier.size(32.dp)
                )


            }
        })
    }) {
        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Card(Modifier.fillMaxWidth()) {
//                    RatingNameAddress()
                }
            }

        }
    }

}