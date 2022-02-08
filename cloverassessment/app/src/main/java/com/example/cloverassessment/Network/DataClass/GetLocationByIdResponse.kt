package com.example.cloverassessment.Network.DataClass

/*
Location Schema from Rick and Morty API
 */

data class GetLocationByIdResponse(
    val created: String = "",
    val dimension: String = "",
    val id: Int = 0,
    val name: String = "",
    val residents: List<Any> = listOf(),
    val type: String = "",
    val url: String = ""
)