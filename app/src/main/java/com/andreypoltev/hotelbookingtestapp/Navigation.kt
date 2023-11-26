package com.andreypoltev.hotelbookingtestapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeScreen
import com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye.BronirovaniyeViewModel
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelScreen
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelViewModel
import com.andreypoltev.hotelbookingtestapp.screens.nomer.NomerScreen
import com.andreypoltev.hotelbookingtestapp.screens.nomer.NomerViewModel
import com.andreypoltev.hotelbookingtestapp.screens.oplacheno.OplachenoScreen
import com.andreypoltev.hotelbookingtestapp.util.Routes

@Composable
fun Navigation(
    hotelViewModel: HotelViewModel,
    nomerViewModel: NomerViewModel,
    bronirovaniyeViewModel: BronirovaniyeViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.hotelScreen) {


        composable(Routes.hotelScreen) {
            HotelScreen(viewModel = hotelViewModel, navController)

        }

        composable(route = Routes.nomerScreen + "/{hotel_name}") {
            NomerScreen(viewModel = nomerViewModel, navController, it.arguments?.getString("hotel_name")?: "Отель")


        }

        composable(Routes.bronirovaniyeScreen) {
            BronirovaniyeScreen(viewModel = bronirovaniyeViewModel, navController)

        }

        composable(Routes.oplachenoScreen) {
            OplachenoScreen(viewModel = hotelViewModel, navController)

        }

    }


}