package com.example.cloverassessment.Network.DataClass

/*
Assists Pagenation process, Keeps track of current page, next and previous
 */

data class PageInfo(
    val count: Int = 0,
    val pages: Int = 0,
    val next: String? = null,
    val prev: String? = null
)
