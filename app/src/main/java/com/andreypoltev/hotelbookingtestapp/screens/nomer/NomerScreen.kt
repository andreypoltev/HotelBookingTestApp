package com.andreypoltev.hotelbookingtestapp.screens.nomer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.composables.CustomButton
import com.andreypoltev.hotelbookingtestapp.composables.CustomCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomColumn
import com.andreypoltev.hotelbookingtestapp.composables.CustomPeculiaritiesCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomTopBar
import com.andreypoltev.hotelbookingtestapp.util.Routes
import com.andreypoltev.hotelbookingtestapp.util.formatAsCurrency

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun NomerScreen(viewModel: NomerViewModel, navController: NavHostController, string: String) {

    val state = viewModel.state.collectAsState()

    Scaffold(topBar = {
        CustomTopBar(text = string, navController = navController)
    }) {
        LazyColumn(
            modifier = Modifier.padding(
//                start = 16.dp,
//                end = 16.dp,
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(state.value) {

                val pageCount: Int = it.imageUrls?.size ?: 0

                val pagerState = rememberPagerState {
                    pageCount
                }


                CustomCard {
                    CustomColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

                        CustomCard {
                            CustomCard {

                                Box(Modifier.fillMaxSize()) {


                                    HorizontalPager(state = pagerState) { page ->
                                        AsyncImage(
                                            model = it.imageUrls?.get(page),
                                            contentDescription = "Hotel Photo",
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

                                }
                            }



                            Text(
                                text = it.name.toString(),
                                style = MaterialTheme.typography.titleLarge
                            )

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                it.peculiarities?.forEach {
                                    CustomPeculiaritiesCard(it.toString())
                                }

                            }

                            Card(
                                shape = RoundedCornerShape(8.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color("#0D72FF".toColorInt()).copy(0.1f)
                                ),
                                onClick = {

                                }
                            ) {
                                Row(
                                    Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Подробнее о номере",
                                        fontSize = 16.sp,
                                        color = Color("#0D72FF".toColorInt()),
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Icon(
                                        painter = painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.nomer_details_forward_button),
                                        contentDescription = "Room Details",
                                        tint = Color("#0D72FF".toColorInt())
                                    )


                                }


                            }



                            Text(
                                text = formatAsCurrency(it.price.toString()),
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Light
                            )


                            CustomButton(
                                text = "Выбрать номер",
                                navController = navController,
                                navDestination = Routes.bronirovaniyeScreen
                            )
                        }

                    }
                }

            }

        }


    }


}