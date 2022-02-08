package com.example.cloverassessment.Network.DataClass

/*
Hosts list of GetCharacterByIdResponse types as well as page info
meta data for pagenation
 */


data class GetCharactersPageResponse(
    val info: PageInfo = PageInfo(),
    val results: List<GetCharacterByIdResponse> = emptyList()
)
