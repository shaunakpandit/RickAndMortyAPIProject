package com.example.cloverassessment.Repository

import androidx.paging.DataSource
import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Repository.CharactersDataSource
import com.example.cloverassessment.Repository.CharactersRepository
import kotlinx.coroutines.CoroutineScope

class CharactersDataSourceFactory(
    private val coroutineScope: CoroutineScope,
    private val repository: CharactersRepository
): DataSource.Factory<Int, GetCharacterByIdResponse>() {

    override fun create(): DataSource<Int, GetCharacterByIdResponse> {
        return CharactersDataSource(coroutineScope, repository)
    }
}
