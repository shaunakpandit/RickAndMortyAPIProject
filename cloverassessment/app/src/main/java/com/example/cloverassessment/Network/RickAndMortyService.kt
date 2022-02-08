package com.example.cloverassessment.Network

import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetCharactersPageResponse
import com.example.cloverassessment.Network.DataClass.GetLocationByIdResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
API call service called by retrofit implementation
Provides proper terminals and types of calls
 */

interface RickAndMortyService {

    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdResponse>


    @GET("character/")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<GetCharactersPageResponse>

    @GET("location/{location-id}")
    suspend fun getLocationById(
        @Path("location-id") locationId: Int
    ): Response<GetLocationByIdResponse>
}