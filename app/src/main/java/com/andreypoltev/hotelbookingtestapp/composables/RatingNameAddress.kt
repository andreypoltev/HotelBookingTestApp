package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.R
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeResponseModel
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelResponseModel

@Composable
fun RatingNameAddressHotel(state: State<HotelResponseModel>) {

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
                model = R.drawable.star,
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

    Text(
        text = state.value.adress.toString(),
        fontWeight = FontWeight.Medium,
        color = Color("#0D72FF".toColorInt()),
        modifier = Modifier.clickable {

        }
    )

}

@Composable
fun RatingNameAddressBronirovaniye(state: State<BronirovaniyeResponseModel>) {

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
                model = R.drawable.star,
                contentDescription = "Review Star Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = state.value.horating.toString() + " " + state.value.ratingName.toString(),
                fontWeight = FontWeight.Medium,
                color = Color("#FFA800".toColorInt())
            )


        }
    }

    Text(
        text = state.value.hotelName.toString(),
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.W400
    )

    Text(
        text = state.value.hotelAdress.toString(),
        fontWeight = FontWeight.Medium,
        color = Color("#0D72FF".toColorInt()),
        modifier = Modifier.clickable {

        }
    )

}