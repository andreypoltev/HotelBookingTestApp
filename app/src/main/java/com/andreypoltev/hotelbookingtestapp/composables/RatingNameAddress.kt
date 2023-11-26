package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.andreypoltev.hotelbookingtestapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingNameAddress(name: String, address: String, rating: String, ratingName: String) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color("#FFC700".toColorInt()).copy(0.2f)
                )
            ) {
                Row(
                    Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
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
                        text = "$rating $ratingName",
                        fontWeight = FontWeight.Medium,
                        color = Color("#FFA800".toColorInt())
                    )


                }
            }

            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W400
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                onClick = {

                }
            ) {
                Text(
                    text = address,
                    fontWeight = FontWeight.Medium,
                    color = Color("#0D72FF".toColorInt()),

                    )


            }

        }
    }

}