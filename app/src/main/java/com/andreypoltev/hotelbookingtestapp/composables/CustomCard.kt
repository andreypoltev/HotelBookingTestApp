package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomCard(
//    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,

//    colors: CardColors = CardDefaults.cardColors(containerColor = Color.White)
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        content = content,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),

        )
}
