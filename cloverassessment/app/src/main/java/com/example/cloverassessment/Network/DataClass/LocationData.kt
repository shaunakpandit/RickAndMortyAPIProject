package com.example.cloverassessment.Network.DataClass

/*
Domain Level LocationData Type, currently identical to response type
 */

data class LocationData (
    val created: String = "",
    val dimension: String = "",
    val id: Int = 0,
    val name: String = "",
    val residents: List<Any> = listOf(),
    val type: String = "",
    val url: String = ""
)