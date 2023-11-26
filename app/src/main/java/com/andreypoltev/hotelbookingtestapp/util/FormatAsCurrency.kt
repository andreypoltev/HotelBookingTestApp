package com.andreypoltev.hotelbookingtestapp.util

fun formatAsCurrency(string: String): String {

    return string.reversed().chunked(3)
        .joinToString(" ").reversed() + " ₽"


}