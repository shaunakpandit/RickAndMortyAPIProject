package com.example.cloverassessment.Network.DataClass

/*
Translates CharacterByIdResponse into type Character
Removes date created, and url fields. Adds LocationData
for current location data
 */

object CharacterMapper {

    fun buildFrom(response: GetCharacterByIdResponse, locationResponse: GetLocationByIdResponse): Character {
        return Character(
            episode = emptyList(),
            gender = response.gender,
            image = response.image,
            id = response.id,
            location = Character.Location(
                name = response.location.name,
                url = response.location.url
            ),
            name = response.name,
            origin = Character.Origin(
                name = response.origin.name,
                url = response.origin.name
            ),
            species = response.species,
            status = response.status,
            locationData = LocationMapper.buildFrom(locationResponse)
        )
    }
}