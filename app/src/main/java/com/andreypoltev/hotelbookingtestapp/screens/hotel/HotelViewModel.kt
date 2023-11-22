package com.andreypoltev.hotelbookingtestapp.screens.hotel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreypoltev.hotelbookingtestapp.Links
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

class HotelViewModel : ViewModel() {

    private val _flowOfHotelResponseModel = MutableStateFlow(HotelResponseModel())
    val state = _flowOfHotelResponseModel.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfHotelResponseModel.value = getResponse()
            getResponse()

        }

        viewModelScope.launch(Dispatchers.IO) {}
    }

    suspend fun getResponse(): HotelResponseModel {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        val response = client.get(Links.HOTELS)
        client.close()

        return response.body()


    }

}