package com.example.cloverassessment.Repository

import com.example.cloverassessment.Network.DataClass.Character
import com.example.cloverassessment.Network.DataClass.CharacterMapper
import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetLocationByIdResponse
import com.example.cloverassessment.Network.NetworkLayer
/*
Access Indivudal Character information as well as current location information from
API Client
 */

class MainRepository {

    suspend fun getCharacterById(characterId: Int): Character? {

        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if(!request.isSuccessful || request.failed) {
            return null
        }

        var currentLocationId = request.body.location.url.toString()

        currentLocationId = currentLocationId.substring(currentLocationId.toString().lastIndexOf("/") + 1)


        val location = getLocationById(currentLocationId.toInt())

        return CharacterMapper.buildFrom(response = request.body, location)
    }


    private suspend fun getLocationById(locationId: Int): GetLocationByIdResponse {

        val request = NetworkLayer.apiClient.getLocationById(locationId)

        if(!request.isSuccessful || request.failed) {
            return GetLocationByIdResponse()
        } else {
            return request.body
        }
    }

}
