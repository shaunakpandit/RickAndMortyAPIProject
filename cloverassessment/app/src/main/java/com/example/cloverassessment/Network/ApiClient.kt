package com.example.cloverassessment.Network

import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetCharactersPageResponse
import com.example.cloverassessment.Network.DataClass.GetLocationByIdResponse
import com.example.cloverassessment.Network.DataClass.SimpleResponse
import retrofit2.Response

/*
API Client with SafeApiCall implementation
 */

class ApiClient(private val rickAndMortyService: RickAndMortyService) {

    suspend fun getCharacterById(characterId: Int): SimpleResponse<GetCharacterByIdResponse> {
        return safeApiCall {rickAndMortyService.getCharacterById(characterId) }
    }

    suspend fun getCharactersPage(pageIndex: Int): SimpleResponse<GetCharactersPageResponse> {
        return safeApiCall { rickAndMortyService.getCharactersPage(pageIndex) }
    }

    suspend fun getLocationById(locationId: Int): SimpleResponse<GetLocationByIdResponse> {
        return safeApiCall {rickAndMortyService.getLocationById(locationId) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}
