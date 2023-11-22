package com.andreypoltev.hotelbookingtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelViewModel
import com.andreypoltev.hotelbookingtestapp.screens.room.RoomScreen
import com.andreypoltev.hotelbookingtestapp.screens.room.RoomViewModel
import com.andreypoltev.hotelbookingtestapp.ui.theme.HotelBookingTestAppTheme

class MainActivity : ComponentActivity() {

    private val hotelViewModel by viewModels<HotelViewModel>()
    private val roomViewModel by viewModels<RoomViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelBookingTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    HotelScreen(hotelViewModel)
                    RoomScreen(roomViewModel)
//                    Greeting("Android")
                }
            }
        }
    }
}