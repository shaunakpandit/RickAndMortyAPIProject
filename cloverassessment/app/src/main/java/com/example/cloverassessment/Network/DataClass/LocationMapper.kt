package com.example.cloverassessment.Network.DataClass

/*
Maps from Rick and Morty Schema to Domain level Schema of Location Data
 */

object LocationMapper {

    fun buildFrom(location: GetLocationByIdResponse) : LocationData {
        return LocationData(
            created = location.created,
            dimension = location.dimension,
            id = location.id,
            name = location.name,
            residents = location.residents,
            type = location.type,
            url = location.url
        )
    }
}