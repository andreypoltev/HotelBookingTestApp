package com.andreypoltev.hotelbookingtestapp.screens.nomer

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

class NomerViewModel : ViewModel() {

    private val _flowOfNomerResponseModel = MutableStateFlow(listOf<NomerResponseModel.Room>())
    val state = _flowOfNomerResponseModel.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfNomerResponseModel.value = getResponse()
            getResponse()

        }

//        viewModelScope.launch(Dispatchers.IO) {}
    }

    suspend fun getResponse(): List<NomerResponseModel.Room> {

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

        val response: NomerResponseModel = client.get(Links.NOMER).body()
        client.close()

        if (response.rooms == null)
            return emptyList()
        else
            return response.rooms


    }




}