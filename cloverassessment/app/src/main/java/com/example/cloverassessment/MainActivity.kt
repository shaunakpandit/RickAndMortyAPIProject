package com.example.cloverassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.cloverassessment.epoxy.CharacterDetailsEpoxyController

/*
Handles Character Details View
 */

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val epoxyController = CharacterDetailsEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //observe current character live data
        viewModel.charByIdLiveData.observe(this) { response ->
            epoxyController.character = response

            if(response == null) {
                Toast.makeText(this@MainActivity, "Unsucessful Network Call", Toast.LENGTH_SHORT)
                    .show()
                return@observe
            }

        }

        viewModel.refreshCharacter(intent.getIntExtra("characterIdExtra", 1))

        // initlaize epoxy recycler view

        val epoxyRecylerView = findViewById<EpoxyRecyclerView>(R.id.epoxyRecylerView)
        epoxyRecylerView.setControllerAndBuildModels(epoxyController)
    }

    // Functionality for back button on Character Details Page
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}