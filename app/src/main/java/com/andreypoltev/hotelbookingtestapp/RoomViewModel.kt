package com.andreypoltev.hotelbookingtestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensionProvider
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class RoomViewModel : ViewModel() {

    private val _flowOfRoomResponseModel = MutableStateFlow(listOf<RoomResponseModel.Room>())
    val state = _flowOfRoomResponseModel.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfRoomResponseModel.value = getResponse()
            getResponse()

        }

//        viewModelScope.launch(Dispatchers.IO) {}
    }

    suspend fun getResponse(): List<RoomResponseModel.Room> {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }

//            install(JsonFeature)

        }

        val response: RoomResponseModel = client.get(Links.ROOMS).body()
        client.close()

        if (response.rooms == null)
            return emptyList()
        else
            return response.rooms


    }




}