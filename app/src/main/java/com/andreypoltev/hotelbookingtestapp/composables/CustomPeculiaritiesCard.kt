package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable

fun CustomPeculiaritiesCard(
    text: String
) {
    Card(
//        content = content,
        colors = CardDefaults.cardColors(
            containerColor = Color(
                "#FBFBFC".toColorInt()
            )
        ), shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            Modifier.padding(
                horizontal = 12.dp,
                vertical = 4.dp
            ),
            color = Color("#828796".toColorInt())
        )

    }

}