package com.andreypoltev.hotelbookingtestapp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelResponseModel(
    val id: Int? = null,
    val name: String? = null,
    val adress: String? = null,
    @SerialName("minimal_price")
    val minimalPrice: Int? = null,
    @SerialName("price_for_it")
    val priceForIt: String? = null,
    val rating: Int? = null,
    @SerialName("rating_name")
    val ratingName: String? = null,
    @SerialName("image_urls")
    val imageUrls: List<String?>? = null,
    @SerialName("about_the_hotel")
    val aboutTheHotel: AboutTheHotel? = null
) {
    @Serializable
    data class AboutTheHotel(
        val description: String? = null,
        val peculiarities: List<String?>? = null
    )
}