package com.andreypoltev.hotelbookingtestapp.screens.room


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomResponseModel(
    val rooms: List<Room>? = null
) {
    @Serializable
    data class Room(
        val id: Int? = null,
        val name: String? = null,
        val price: Int? = null,
        @SerialName("price_per")
        val pricePer: String? = null,
        val peculiarities: List<String?>? = null,
        @SerialName("image_urls")
        val imageUrls: List<String?>? = null
    )
}