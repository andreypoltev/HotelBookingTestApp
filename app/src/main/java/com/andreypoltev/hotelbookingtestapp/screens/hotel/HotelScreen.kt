package com.andreypoltev.hotelbookingtestapp.screens.hotel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
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
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddress
import com.andreypoltev.hotelbookingtestapp.util.Routes
import com.andreypoltev.hotelbookingtestapp.util.formatAsCurrency

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
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
                            Box {
                                HorizontalPager(state = pagerState) { page ->
                                    AsyncImage(
                                        model = state.value.imageUrls?.get(page),
                                        contentDescription = state.value.name,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.aspectRatio(530f / 375f)
//                placeholder = painterResource(R.drawable.ic_call_answer)
                                    )


                                }

                                Card(
                                    Modifier
                                        .wrapContentHeight()
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    shape = RoundedCornerShape(4.dp)
                                ) {


                                    Row(
                                        Modifier
                                            .wrapContentHeight()
//                                            .fillMaxWidth()
//                                            .align(Alignment.BottomCenter)
                                            .padding(horizontal = 4.dp, vertical = 4.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        repeat(pagerState.pageCount) { iteration ->
                                            val color =
                                                if (pagerState.currentPage == iteration) Color.Black else Color.Black.copy(
                                                    0.05f
                                                )
                                            Box(
                                                modifier = Modifier
                                                    .padding(horizontal = 4.dp)
                                                    .clip(CircleShape)
                                                    .background(color)
                                                    .size(8.dp)
                                            )
                                        }
                                    }
                                }

//                                HorizontalPagerIndicator()
//                                HorizontalPagerIndicator

                            }

//                            CustomPageIndicator(
//                                pagerState = pagerState,
//                                imageUri = state.value.imageUrls?.get(page).toString(),
//                                contentDescription =
//                            )


                        }

                        RatingNameAddress(
                            name = state.value.name.toString(),
                            address = state.value.adress.toString(),
                            rating = state.value.rating.toString(),
                            ratingName = state.value.ratingName.toString()
                        )

//                        RatingNameAddressHotel(state)


                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Text(
                                text = "от " + formatAsCurrency(state.value.minimalPrice.toString()),
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
                    CustomColumn {

                        Text(text = "Об отеле", style = MaterialTheme.typography.headlineMedium)

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            state.value.aboutTheHotel?.peculiarities?.forEach {
                                CustomPeculiaritiesCard(it.toString())
                            }

                        }

//                        LazyVerticalGrid(
//
//                            modifier = Modifier
//                                .heightIn(max = 100.dp),
//                            columns = GridCells.Adaptive(minSize = 128.dp)
//                        ) {
//                            state.value.aboutTheHotel?.peculiarities?.forEach {
//                                item {
//                                    CustomPeculiaritiesCard(it.toString())
//                                }
//                            }
//
//                        }


//                        LazyHorizontalStaggeredGrid(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .heightIn(max = 80.dp),
//                            verticalArrangement = Arrangement.spacedBy(8.dp),
//                            horizontalItemSpacing = 8.dp,
//                            rows = StaggeredGridCells.Adaptive(200.dp),
//                            content = {
//
//                                state.value.aboutTheHotel?.peculiarities?.forEach {
//                                    item {
//                                        CustomPeculiaritiesCard(it.toString())
//                                    }
//                                }
//
//
//                            }
//                        )

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