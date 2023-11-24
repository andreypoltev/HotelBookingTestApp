package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import android.content.ClipData.Item
import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
import com.andreypoltev.hotelbookingtestapp.R
import com.andreypoltev.hotelbookingtestapp.composables.RatingNameAddressBronirovaniye

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BronirovaniyeScreen(viewModel: BronirovaniyeViewModel) {

    val state = viewModel.state.collectAsState()

    Scaffold(
        topBar = {
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
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            item {
                Card(
                    Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(Modifier.padding(16.dp)) {

                        RatingNameAddressBronirovaniye(state)
                    }


                }
            }

            item {
                Card(
                    Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
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


            item {
                Column(Modifier.padding(16.dp)) {
                    Text(text = "Информация о покупателе", fontSize = 22.sp,
                        color = Color.Black)

                    Spacer(modifier = Modifier.size(20.dp))


                    var phoneNumber by remember { mutableStateOf("") }

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = { Text("Номер телефона") },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color("#F6F6F9".toColorInt()),
                            textColor = Color("#14142B".toColorInt()),
                            focusedLabelColor = Color("#A9ABB7".toColorInt()),
                            unfocusedLabelColor = Color("#A9ABB7".toColorInt()),
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(12.dp)


                    )


                    Spacer(modifier = Modifier.size(8.dp))


                    var eMail by remember { mutableStateOf("") }

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = eMail,
                        onValueChange = { eMail = it },
                        label = { Text("Почта") },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color("#F6F6F9".toColorInt()),
                            textColor = Color("#14142B".toColorInt()),
                            focusedLabelColor = Color("#A9ABB7".toColorInt()),
                            unfocusedLabelColor = Color("#A9ABB7".toColorInt()),
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        fontSize = 14.sp,
                        text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
                        color = Color("#828796".toColorInt())
                    )


                }
            }

        }
    }

}