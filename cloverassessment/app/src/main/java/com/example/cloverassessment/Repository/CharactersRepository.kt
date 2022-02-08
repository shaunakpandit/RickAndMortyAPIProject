package com.example.cloverassessment.Repository

import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetCharactersPageResponse
import com.example.cloverassessment.Network.NetworkLayer

/*
Accesses character data from API Client for the requested page
 */

class CharactersRepository {
    
    suspend fun getCharacterList(pageIndex: Int): List<GetCharacterByIdResponse> {
        return emptyList()
    }

    suspend fun getCharactersPage(pageIndex: Int): GetCharactersPageResponse? {
        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)

        if (request.failed || !request.isSuccessful) {
            return null
        }

        return request.body
    }

}
