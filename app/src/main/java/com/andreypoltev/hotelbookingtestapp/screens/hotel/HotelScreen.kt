package com.andreypoltev.hotelbookingtestapp.screens.hotel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.composables.CustomBottomBar
import com.andreypoltev.hotelbookingtestapp.composables.CustomCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomColumn
import com.andreypoltev.hotelbookingtestapp.composables.CustomPeculiaritiesCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomProgressIndicator
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddressHotel
import com.andreypoltev.hotelbookingtestapp.util.Routes

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HotelScreen(viewModel: HotelViewModel, navController: NavHostController) {

    val state = viewModel.state.collectAsState()

    val isLoading by viewModel.isLoading.collectAsState()

    val pageCount: Int =
        if (state.value.imageUrls != null)
            state.value.imageUrls!!.size
        else
            0


//    val pagerState = rememberPagerState(pageCount = state.value.imageUrls?.size)
    val pagerState = rememberPagerState {
        pageCount
    }

    if (isLoading) {
        CustomProgressIndicator()

    } else {


        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = {
                    Text(
                        text = "Отель", fontSize = 18.sp,
                        color = Color("#000000".toColorInt()),
                        textAlign = TextAlign.Center
                    )
                })
            },
            bottomBar = {
                CustomBottomBar(
                    text = "К выбору номера",
                    navController = navController,
                    navDestination = Routes.nomerScreen + "/" + state.value.name
                )
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

                CustomCard {
                    CustomColumn {

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

                        RatingNameAddressHotel(state)


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

                CustomCard {
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
                                        CustomPeculiaritiesCard(it.toString())
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

                                Card(
                                    onClick = {},
                                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
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

                                }

                                Divider(Modifier.padding(start = 36.dp))

                                Card(
                                    onClick = {},
                                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                                ) {

                                    Row(
                                        Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {

                                        Icon(
                                            painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.tick_square),
                                            "Forward Arrow",
                                            Modifier.size(24.dp)
                                        )

//                                Icon()
                                        Column() {
                                            Text(text = "Что включено", fontSize = 16.sp)
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

                                Divider(Modifier.padding(start = 36.dp))

                                Card(
                                    onClick = {},
                                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                                ) {

                                    Row(
                                        Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {

                                        Icon(
                                            painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.close_square),
                                            "Forward Arrow",
                                            Modifier.size(24.dp)
                                        )

//                                Icon()
                                        Column() {
                                            Text(text = "Что не включено", fontSize = 16.sp)
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
    }

}