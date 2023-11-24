package com.andreypoltev.hotelbookingtestapp.screens.bronirovaniye


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BronirovaniyeResponseModel(
    val id: Int? = null,
    @SerialName("hotel_name")
    val hotelName: String? = null,
    @SerialName("hotel_adress")
    val hotelAdress: String? = null,
    val horating: Int? = null,
    @SerialName("rating_name")
    val ratingName: String? = null,
    val departure: String? = null,
    @SerialName("arrival_country")
    val arrivalCountry: String? = null,
    @SerialName("tour_date_start")
    val tourDateStart: String? = null,
    @SerialName("tour_date_stop")
    val tourDateStop: String? = null,
    @SerialName("number_of_nights")
    val numberOfNights: Int? = null,
    val room: String? = null,
    val nutrition: String? = null,
    @SerialName("tour_price")
    val tourPrice: Int? = null,
    @SerialName("fuel_charge")
    val fuelCharge: Int? = null,
    @SerialName("service_charge")
    val serviceCharge: Int? = null
)