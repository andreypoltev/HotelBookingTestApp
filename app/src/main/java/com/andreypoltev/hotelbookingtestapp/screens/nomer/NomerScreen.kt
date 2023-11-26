package com.andreypoltev.hotelbookingtestapp.screens.nomer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.composables.CustomCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomColumn
import com.andreypoltev.hotelbookingtestapp.composables.CustomTopBar
import com.andreypoltev.hotelbookingtestapp.util.Routes

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
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
                    CustomColumn {

                        Card {


                            HorizontalPager(state = pagerState) { page ->
                                AsyncImage(
                                    model = it.imageUrls?.get(page),
                                    contentDescription = "Hotel Photo",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.aspectRatio(530f / 375f)
//                placeholder = painterResource(R.drawable.ic_call_answer)
                                )


                            }
                        }


                        Text(text = it.name.toString(), style = MaterialTheme.typography.titleLarge)

                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            it.peculiarities?.forEach {
                                item {
                                    Card(shape = RoundedCornerShape(8.dp)) {
                                        Text(
                                            text = it.toString(),
                                            Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )

                                    }
                                }
                            }
                        }

                        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(8.dp)) {

                            Text(
                                text = "Подробнее о номере",
                                fontSize = 16.sp,

                                )

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Room Details"
                            )


                        }




                        Text(
                            text = it.price.toString() + " ₽",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Light
                        ) // 000 000 000


                        Button(
                            onClick = { navController.navigate(Routes.bronirovaniyeScreen) },
                            Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "Выбрать номер",
                                Modifier.padding(8.dp),
                                style = MaterialTheme.typography.titleMedium
                            ) // Need a strings!

                        }

                    }
                }

            }

        }


    }


}