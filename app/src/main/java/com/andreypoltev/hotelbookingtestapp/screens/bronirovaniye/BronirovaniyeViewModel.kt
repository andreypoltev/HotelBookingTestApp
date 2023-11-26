package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreypoltev.hotelbookingtestapp.Tourist
import com.andreypoltev.hotelbookingtestapp.util.Links
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

    private val _tourists = MutableStateFlow<List<Tourist>>(emptyList())
    val tourists = _tourists.asStateFlow()


    private val _flowOfHotelResponseModel = MutableStateFlow(BronirovaniyeResponseModel())
    val state = _flowOfHotelResponseModel.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _flowOfHotelResponseModel.value = getResponse()
            addTourist()


        }
    }

    fun addTourist() {
        viewModelScope.launch(Dispatchers.IO) {
            val currentList = _tourists.value
            val updatedList = currentList + Tourist()
            _tourists.value = updatedList

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