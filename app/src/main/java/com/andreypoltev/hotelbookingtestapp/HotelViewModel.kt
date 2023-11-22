package com.andreypoltev.hotelbookingtestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _flowOfResponseModel = MutableStateFlow(ResponseModel())
    val state = _flowOfResponseModel.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfResponseModel.value = getResponse()
            getResponse()

        }

        viewModelScope.launch(Dispatchers.IO) {}
    }

    suspend fun getResponse(): ResponseModel {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        val response = client.get("https://run.mocky.io/v3/d144777c-a67f-4e35-867a-cacc3b827473")
        client.close()

        return response.body()


    }

}