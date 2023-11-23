package com.andreypoltev.hotelbookingtestapp.screens.hotel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HotelScreen(viewModel: HotelViewModel) {

    val state = viewModel.state.collectAsState()
    val pageCount: Int =
        if (state.value.imageUrls != null)
            state.value.imageUrls!!.size
        else
            0


//    val pagerState = rememberPagerState(pageCount = state.value.imageUrls?.size)
    val pagerState = rememberPagerState {
        pageCount
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Отель") })
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
                    Text(text = "К выбору номера", fontSize = 16.sp)

                }
            }
        }
    ) {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 0.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Card {
                        HorizontalPager(state = pagerState) { page ->
                            AsyncImage(
                                model = state.value.imageUrls?.get(page),
                                contentDescription = state.value.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.aspectRatio(530f / 375f)
//                placeholder = painterResource(R.drawable.ic_call_answer)
                            )


                        }
                    }


                    Card(
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color("#FFC700".toColorInt()).copy(0.2f)
                        )
                    ) {
                        Row(
                            Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
//
//
                            AsyncImage(
                                model = com.andreypoltev.hotelbookingtestapp.R.drawable.star,
                                contentDescription = "Review Star Icon",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.height(16.dp)
                            )

                            Text(
                                text = state.value.rating.toString() + " " + state.value.ratingName.toString(),
                                fontWeight = FontWeight.Medium,
                                color = Color("#FFA800".toColorInt())
                            )


                        }
                    }

                    Text(
                        text = state.value.name.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.W400
                    )

//                    TextButton(onClick = { /*TODO*/ }) {
//                        Text(text = state.value.adress.toString(), color = Color("#0D72FF".toColorInt()))
//
//                    }

                    Text(
                        text = state.value.adress.toString(),
                        fontWeight = FontWeight.Medium,
                        color = Color("#0D72FF".toColorInt()),
                        modifier = Modifier.clickable {

                        }
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = "от " + state.value.minimalPrice.toString() + " ₽",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Light
                        ) // 000 000 000

                        Text(
                            text = state.value.priceForIt.toString(),
                            color = Color("#828796".toColorInt())
                        )

                    }


                }

            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Text(text = "Об отеле", style = MaterialTheme.typography.headlineMedium)



                    LazyHorizontalStaggeredGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 80.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalItemSpacing = 8.dp,
                        rows = StaggeredGridCells.Fixed(2),
                        content = {

                            state.value.aboutTheHotel?.peculiarities?.forEach {
                                item {
                                    Card(
                                        colors = CardDefaults.cardColors(containerColor = Color("#FBFBFC".toColorInt())),
                                    ) {
                                        Text(
                                            text = it.toString(),
                                            Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                            color = Color("#828796".toColorInt())
                                        )
                                    }
                                }
                            }


                        }
                    )

                    Text(text = state.value.aboutTheHotel?.description.toString())

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color("#FBFBFC".toColorInt()))
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {

                                Icon(
                                    painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.emoji_happy),
                                    "Forward Arrow",
                                    Modifier.size(24.dp)
                                )

//                                Icon()
                                Column() {
                                    Text(text = "Удобства", fontSize = 16.sp)
                                    Text(text = "Самое необходимое", fontSize = 14.sp)
                                }

                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.forwardarrow),
                                    "Forward Arrow",
                                    Modifier
                                        .size(20.dp)
                                )


                            }


                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {

                                Icon(
                                    painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.emoji_happy),
                                    "Forward Arrow",
                                    Modifier.size(24.dp)
                                )

//                                Icon()
                                Column() {
                                    Text(text = "Удобства", fontSize = 16.sp)
                                    Text(text = "Самое необходимое", fontSize = 14.sp)
                                }

                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.forwardarrow),
                                    "Forward Arrow",
                                    Modifier
                                        .size(20.dp)
                                )


                            }


                        }
                    }


                }

            }


        }
    }
}