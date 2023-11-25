package com.andreypoltev.hotelbookingtestapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.andreypoltev.hotelbookingtestapp.R
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeViewModel

@Composable
fun AddTouristButton(viewModel: BronirovaniyeViewModel) {
    IconButton(
        onClick = { viewModel.addTourist() },
        Modifier
            .size(32.dp)
            .background(
                color = Color("#0D72FF".toColorInt()),
                shape = RoundedCornerShape(16.dp)
            ),
//                            colors = IconButtonDefaults.iconButtonColors(containerColor = Color("#0D72FF".toColorInt())),

    ) {
        Icon(
            painter = painterResource(id = R.drawable.add_tourist_button),
            contentDescription = "Add Tourist Button",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )


    }
}