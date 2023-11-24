package com.andreypoltev.hotelbookingtestapp.screens.oplacheno

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OplachenoScreen(viewModel: HotelViewModel) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Заказ оплачен",
                    fontSize = 18.sp
                )
            },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {

                        Icon(
                            painter = painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.arrow_back),
                            contentDescription = "Go Back", Modifier.size(32.dp)
                        )


                    }
                })
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.White) {
//                Text(text = "zvada")
                Button(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#0D72FF".toColorInt())
                    )
                ) {
                    Text(text = "Супер!", fontSize = 16.sp)

                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
        ) {

            Box(modifier = Modifier.size(94.dp), Alignment.Center) {

                Canvas(Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color("#F6F6F9".toColorInt()),
                    )

                }


                AsyncImage(
                    model = com.andreypoltev.hotelbookingtestapp.R.drawable.party_popper,
                    contentDescription = "Party Popper Success",
                    Modifier.size(44.dp)
//                contentScale = ContentScale.Crop,
//                placeholder = painterResource(R.drawable.ic_call_answer)
                )

            }






            Spacer(modifier = Modifier.size(32.dp))


            Text(text = "Ваш заказ принят в работу", fontSize = 22.sp)
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Подтверждение заказа №104893 может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

        }
    }

}