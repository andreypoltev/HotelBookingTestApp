package com.andreypoltev.hotelbookingtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeScreen
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeViewModel
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelViewModel
import com.andreypoltev.hotelbookingtestapp.screens.nomer.NomerViewModel
import com.andreypoltev.hotelbookingtestapp.ui.theme.HotelBookingTestAppTheme

class MainActivity : ComponentActivity() {

    private val hotelViewModel by viewModels<HotelViewModel>()
    private val nomerViewModel by viewModels<NomerViewModel>()
    private val bronirovaniyeViewModel by viewModels<BronirovaniyeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {


        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )

        super.onCreate(savedInstanceState)
        setContent {
            HotelBookingTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BronirovaniyeScreen(bronirovaniyeViewModel)
//                    OplachenoScreen(viewModel = hotelViewModel)
//                    GeneratedCode()
//                    HotelScreen(hotelViewModel)
//                    RoomScreen(roomViewModel)

//                    Greeting("Android")

                }
            }
        }
    }
}