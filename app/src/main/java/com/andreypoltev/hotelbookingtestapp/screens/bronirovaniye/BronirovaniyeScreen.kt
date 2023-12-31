package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.andreypoltev.hotelbookingtestapp.composables.CustomBottomBar
import com.andreypoltev.hotelbookingtestapp.composables.CustomCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomColumn
import com.andreypoltev.hotelbookingtestapp.composables.CustomTextField
import com.andreypoltev.hotelbookingtestapp.composables.CustomTopBar
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddress
import com.andreypoltev.hotelbookingtestapp.util.Routes
import com.andreypoltev.hotelbookingtestapp.util.formatAsCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BronirovaniyeScreen(viewModel: BronirovaniyeViewModel, navController: NavHostController) {

    val state = viewModel.state.collectAsState()

    val tourists = viewModel.tourists.collectAsState()

    Scaffold(
        topBar = {
            CustomTopBar(text = "Бронирование", navController)
        },
        bottomBar = {
            CustomBottomBar(
                text = "Оплатить",
                navController = navController,
                navDestination = Routes.oplachenoScreen
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // RatingNameAddress
            item {
                CustomCard {
                    CustomColumn {
                        RatingNameAddress(
                            name = state.value.hotelName.toString(),
                            address = state.value.hotelAdress.toString(),
                            rating = state.value.horating.toString(),
                            ratingName = state.value.ratingName.toString()
                        )

                    }


                }
            }

            // Hotel info
            item {
                CustomCard {
                    CustomColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Вылет из")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.departure.toString())
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Страна, город")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.arrivalCountry.toString())
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Даты")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.tourDateStart.toString() + " – " + state.value.tourDateStop)
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Кол-во ночей")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.numberOfNights.toString() + " ночей")
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Отель")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.hotelName.toString())
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Номер")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.room.toString())
                        }

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Питание")

                            Spacer(modifier = Modifier.weight(0.5f))

                            Text(text = state.value.nutrition.toString())
                        }


                    }
                }
            }

            // Информация о покупателе
            item {
                CustomCard {
                    CustomColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Text(
                            text = "Информация о покупателе", fontSize = 22.sp,
                            color = Color.Black
                        )

                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            val phoneNumber = remember { mutableStateOf("") }
                            CustomTextField(test = phoneNumber, title = "Номер телефона")


                            val eMail = remember { mutableStateOf("") }
                            CustomTextField(test = eMail, title = "Почта")


                            Text(
                                fontSize = 14.sp,
                                text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
                                color = Color("#828796".toColorInt())
                            )
                        }


                    }
                }
            }

            // Tourists

            items(tourists.value) {

                CustomCard {
                    CustomColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {

                        var isExpanded by remember {
                            mutableStateOf(false)
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Турист", fontSize = 22.sp)

                            Spacer(modifier = Modifier.weight(1f))


                            Card(
                                onClick = { isExpanded = !isExpanded },
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.size(32.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color("#0D72FF".toColorInt()).copy(
                                        0.1f
                                    )
                                )
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {


                                    val id: Int = if (isExpanded)
                                        com.andreypoltev.hotelbookingtestapp.R.drawable.button_expand
                                    else
                                        com.andreypoltev.hotelbookingtestapp.R.drawable.button_hide


                                    Icon(
                                        painter = painterResource(id = id),
                                        contentDescription = "Add tourist button",
                                        modifier = Modifier.size(24.dp),
                                        tint = Color("#0D72FF".toColorInt())
                                    )
                                }


                            }


//                            AddTouristButton(viewModel)


                        }



                        if (isExpanded) {

                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                val name = remember { mutableStateOf(it.name) }
                                CustomTextField(test = name, title = "Имя")

                                val lastName = remember { mutableStateOf(it.lastName) }
                                CustomTextField(test = lastName, title = "Фамилия")

                                val dateOfBirth =
                                    remember { mutableStateOf(it.dateOfBirth.toString()) }
                                CustomTextField(test = dateOfBirth, title = "Дата рождения")

                                val citizenship = remember { mutableStateOf(it.citizenship) }
                                CustomTextField(test = citizenship, title = "Номер телефона")

                                val foreignPassportNumber =
                                    remember { mutableStateOf(it.foreignPassportNumber) }
                                CustomTextField(
                                    test = foreignPassportNumber,
                                    title = "Номер загранпаспорта"
                                )

                                val foreignPassportExpirationDate =
                                    remember { mutableStateOf(it.foreignPassportExpirationDate.toString()) }
                                CustomTextField(
                                    test = foreignPassportExpirationDate,
                                    title = "Срок действия загранпаспорта"
                                )
                            }


                        }

                    }


                }


            }


            // Add tourist
            item {
                CustomCard {
                    Row(Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                        Text(text = "Добавить туриста", fontSize = 22.sp)

                        Spacer(modifier = Modifier.weight(1f))

                        Card(
                            onClick = { viewModel.addTourist() },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.size(32.dp),
                            colors = CardDefaults.cardColors(containerColor = Color("#0D72FF".toColorInt()))
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = com.andreypoltev.hotelbookingtestapp.R.drawable.add_tourist_button),
                                    contentDescription = "Add tourist button",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.White
                                )
                            }


                        }


//                        AddTouristButton(viewModel)


                    }
                }
            }

            // Total
            item {
                CustomCard {
                    CustomColumn {
                        Row {
                            Text(text = "Тур", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = formatAsCurrency(state.value.tourPrice.toString()),
                                color = Color.Black,
                                fontSize = 16.sp
                            )

                        }

                        Row {
                            Text(text = "Топливный сбор", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = formatAsCurrency(state.value.fuelCharge.toString()),
                                color = Color.Black,
                                fontSize = 16.sp

                            )

                        }

                        Row {
                            Text(text = "Сервисный сбор", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = formatAsCurrency(state.value.serviceCharge.toString()),
                                color = Color.Black,
                                fontSize = 16.sp

                            )

                        }

                        Row {
                            Text(text = "К оплате", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = formatAsCurrency(
                                    (
                                            (state.value.tourPrice
                                                ?: 0) + (state.value.fuelCharge
                                                ?: 0) + (state.value.serviceCharge
                                                ?: 0)).toString()
                                ),
                                color = Color.Black,
                                fontSize = 16.sp

                            )

                        }


                    }
                }
            }


        }
    }

}