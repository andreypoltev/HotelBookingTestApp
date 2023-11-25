package com.andreypoltev.hotelbookingtestapp

import java.time.LocalDate

data class Tourist(
    val name: String = "",
    val lastName: String = "",
    val dateOfBirth: LocalDate? = null,
    val citizenship: String = "",
    val foreignPassportNumber: String = "",
    val foreignPassportExpirationDate: LocalDate? = null,


    )
