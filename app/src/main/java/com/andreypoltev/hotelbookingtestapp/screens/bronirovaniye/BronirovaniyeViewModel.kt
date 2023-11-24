package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreypoltev.hotelbookingtestapp.Links
import com.andreypoltev.hotelbookingtestapp.screens.hotel.HotelResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class BronirovaniyeViewModel : ViewModel() {

    private val _flowOfHotelResponseModel = MutableStateFlow(BronirovaniyeResponseModel())
    val state = _flowOfHotelResponseModel.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfHotelResponseModel.value = getResponse()


        }
    }

    suspend fun getResponse(): BronirovaniyeResponseModel {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        val response = client.get(Links.BRONIROVANIYE)
        client.close()

        return response.body()


    }

}