package com.andreypoltev.hotelbookingtestapp.screens.oplacheno

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.Routes
import com.andreypoltev.hotelbookingtestapp.composables.CustomBottomBar
import com.andreypoltev.hotelbookingtestapp.composables.CustomTopBar
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelViewModel
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OplachenoScreen(viewModel: HotelViewModel, navController: NavHostController) {

    val randomInt = Random.nextInt(from = 100000, until = Int.MAX_VALUE)

    Scaffold(
        topBar = {
            CustomTopBar(text = "Заказ оплачен", navController = navController)
        },
        bottomBar = {
            CustomBottomBar(text = "Супер!", navController = navController, Routes.hotelScreen)
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


            Text(
                text = "Ваш заказ принят в работу",
                fontSize = 22.sp,
                color = Color("#000000".toColorInt())

            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Подтверждение заказа №$randomInt может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color("#828796".toColorInt())

            )

        }
    }

}