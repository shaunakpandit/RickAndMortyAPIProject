package com.example.cloverassessment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.cloverassessment.epoxy.CharacterListPagingEpoxyController

/*
Activity to manage frontend display of Character List information
 */

class CharacterListActivity: AppCompatActivity() {

    private val epoxyController = CharacterListPagingEpoxyController(::onCharacterSelected)

    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_character_list)

        viewModel.charactersPagedListLiveData.observe(this) { pagedList ->
            epoxyController.submitList(pagedList)

        }

        findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView2).setController(epoxyController)

    }

    private fun onCharacterSelected(characterId: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("characterIdExtra", characterId)

        startActivity(intent)
    }
}