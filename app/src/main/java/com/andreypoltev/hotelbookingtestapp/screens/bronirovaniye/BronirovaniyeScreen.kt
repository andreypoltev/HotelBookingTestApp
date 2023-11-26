package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.andreypoltev.hotelbookingtestapp.composables.AddTouristButton
import com.andreypoltev.hotelbookingtestapp.composables.CustomBottomBar
import com.andreypoltev.hotelbookingtestapp.composables.CustomCard
import com.andreypoltev.hotelbookingtestapp.composables.CustomColumn
import com.andreypoltev.hotelbookingtestapp.composables.CustomOutlinedTextField
import com.andreypoltev.hotelbookingtestapp.composables.CustomTopBar
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddress
import com.andreypoltev.hotelbookingtestapp.util.Routes

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

            item {
                CustomCard {
                    CustomColumn {
                        RatingNameAddress(
                            name = state.value.hotelName.toString(),
                            address = state.value.hotelAdress.toString(),
                            rating = state.value.horating.toString(),
                            ratingName = state.value.ratingName.toString()
                        )

//                        RatingNameAddressBronirovaniye(state)
                    }


                }
            }

            // Hotel info
            item {
                CustomCard {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(text = "Вылет из")
                            Text(text = "Страна, город")
                            Text(text = "Даты")
                            Text(text = "Кол-во ночей")
                            Text(text = "Отель")
                            Text(text = "Номер")
                            Text(text = "Питание")
                        }


                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(text = state.value.departure.toString())
                            Text(text = state.value.arrivalCountry.toString())
                            Text(text = state.value.tourDateStart.toString() + " – " + state.value.tourDateStop)
                            Text(text = state.value.numberOfNights.toString() + " ночей")
                            Text(text = state.value.hotelName.toString())
                            Text(text = state.value.room.toString())
                            Text(text = state.value.nutrition.toString())


                        }

//                        Text(text = "Вылет из " + state.value.departure.toString())

                    }


                }
            }

            // Информация о покупателе
            item {
                CustomCard {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = "Информация о покупателе", fontSize = 22.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.size(20.dp))

                        val phoneNumber = remember { mutableStateOf("") }
                        CustomOutlinedTextField(test = phoneNumber, title = "Номер телефона")

                        Spacer(modifier = Modifier.size(8.dp))

                        val eMail = remember { mutableStateOf("") }
                        CustomOutlinedTextField(test = eMail, title = "Почта")

                        Spacer(modifier = Modifier.size(8.dp))

                        Text(
                            fontSize = 14.sp,
                            text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
                            color = Color("#828796".toColorInt())
                        )

                    }
                }
            }

            // Tourists

            items(tourists.value) {

                CustomCard {
                    Column(Modifier.padding(16.dp)) {

                        Row(Modifier.fillMaxWidth()) {
                            Text(text = "Турист", fontSize = 22.sp)

                            Spacer(modifier = Modifier.weight(1f))

                            AddTouristButton(viewModel)


                        }

                        val name = remember { mutableStateOf(it.name) }
                        CustomOutlinedTextField(test = name, title = "Имя")

                        val lastName = remember { mutableStateOf(it.lastName) }
                        CustomOutlinedTextField(test = lastName, title = "Фамилия")

                        val dateOfBirth = remember { mutableStateOf(it.dateOfBirth.toString()) }
                        CustomOutlinedTextField(test = dateOfBirth, title = "Дата рождения")

                        val citizenship = remember { mutableStateOf(it.citizenship) }
                        CustomOutlinedTextField(test = citizenship, title = "Номер телефона")

                        val foreignPassportNumber =
                            remember { mutableStateOf(it.foreignPassportNumber) }
                        CustomOutlinedTextField(
                            test = foreignPassportNumber,
                            title = "Номер загранпаспорта"
                        )

                        val foreignPassportExpirationDate =
                            remember { mutableStateOf(it.foreignPassportExpirationDate.toString()) }
                        CustomOutlinedTextField(
                            test = foreignPassportExpirationDate,
                            title = "Срок действия загранпаспорта"
                        )


                    }


                }


            }


            // Add tourist
            item {
                CustomCard {
                    Row(Modifier.padding(16.dp)) {
                        Text(text = "Добавить туриста", fontSize = 22.sp)

                        Spacer(modifier = Modifier.weight(1f))

                        AddTouristButton(viewModel)


                    }
                }
            }

            // Total
            item {
                CustomCard {
                    Column(Modifier.padding(16.dp), Arrangement.spacedBy(16.dp)) {
                        Row {
                            Text(text = "Тур", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = state.value.tourPrice.toString())

                        }

                        Row {
                            Text(text = "Топливный сбор", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = state.value.fuelCharge.toString())

                        }

                        Row {
                            Text(text = "Сервисный сбор", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = state.value.serviceCharge.toString())

                        }

                        Row {
                            Text(text = "К оплате", color = Color("#828796".toColorInt()))
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = (
                                        (state.value.tourPrice
                                            ?: 0) + (state.value.fuelCharge
                                            ?: 0) + (state.value.serviceCharge
                                            ?: 0)).toString()
                            )

                        }


                    }
                }
            }


        }
    }

}