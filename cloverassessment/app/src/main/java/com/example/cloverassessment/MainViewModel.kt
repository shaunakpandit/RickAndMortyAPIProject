package com.example.cloverassessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cloverassessment.Network.DataClass.Character
import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetLocationByIdResponse
import com.example.cloverassessment.Repository.MainRepository
import kotlinx.coroutines.launch

/*
Access to Characters Detail Repository
posts data to observable live data
 */
class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private val _charByIdLiveData = MutableLiveData<Character?>()
    val charByIdLiveData: LiveData<Character?> = _charByIdLiveData

    private val _locByIdLiveData = MutableLiveData<GetLocationByIdResponse?>()
    val locByIdLiveData: LiveData<GetLocationByIdResponse?> = _locByIdLiveData

    fun refreshCharacter(characterId: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)

            _charByIdLiveData.postValue(response)
        }
    }

}