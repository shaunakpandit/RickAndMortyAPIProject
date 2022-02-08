package com.example.cloverassessment.epoxy

import com.airbnb.epoxy.EpoxyController
import com.example.cloverassessment.Network.DataClass.Character
import com.example.cloverassessment.Network.DataClass.GetCharacterByIdResponse
import com.example.cloverassessment.Network.DataClass.GetLocationByIdResponse
import com.example.cloverassessment.R
import com.example.cloverassessment.databinding.ModelCharacterDataBinding
import com.example.cloverassessment.databinding.ModelCharacterNameHeaderBinding
import com.example.cloverassessment.databinding.ModelCharacterPictureBinding
import com.squareup.picasso.Picasso


/*
Manage production of Character Details view
 */
class CharacterDetailsEpoxyController: EpoxyController() {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var character: Character? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {

        // handle loading screen
        if (isLoading) {
            LoadingEpoxyModel().id("loading").addTo(this)
            return
        }

        if (character == null) {
            // todo error state
            return
        }

        // Image Data
        ImageEpoxyModel(
            imageUrl = character!!.image
        ).id("image").addTo(this)

        // Header Data
        HeaderEpoxyModel(
            name = character!!.name,
            gender = character!!.gender,
            status = character!!.status
        ).id("header").addTo(this)


        // origin Data

        DataPointEpoxyModel(
            title = "Origin",
            description = character!!.origin.name
        ).id("data_point_1").addTo(this)

        //species Data
        DataPointEpoxyModel(
            title = "Species",
            description = character!!.species
        ).id("data_point_2").addTo(this)

        // Current location
        DataPointEpoxyModel(
            title = "Last Location",
            description = character!!.location.name
        ).id("data_point_3").addTo(this)

        //current location dimension
        DataPointEpoxyModel(
            title = "Location Dimension",
            description = character!!.locationData.dimension
        ).id("data_point_4").addTo(this)

        //cureent location type
        DataPointEpoxyModel(
            title = "Location Type",
            description = character!!.locationData.type
        ).id("data_point_5").addTo(this)

        //num of residents
        DataPointEpoxyModel(
            title = "Number of Residents",
            description = character!!.locationData.residents.size.toString()
        ).id("data_point_6").addTo(this)

    }

    // bind to model_character_header item fields
    data class HeaderEpoxyModel(
        val name: String,
        val gender: String,
        val status: String
    ) : ViewBindingKotlinModel<ModelCharacterNameHeaderBinding>(R.layout.model_character_name_header) {

        override fun ModelCharacterNameHeaderBinding.bind() {
            characterName.hint = status
            characterNameEt.setText(name)

            // handles gender iconography
            if (gender.equals("male", true)) {
                characterGender.setImageResource(R.drawable.ic_male_24)
            } else {
                characterGender.setImageResource(R.drawable.ic_female_24)
            }
        }
    }

    // bind to model_character_picture item fields
    data class ImageEpoxyModel(
        val imageUrl: String
    ) : ViewBindingKotlinModel<ModelCharacterPictureBinding>(R.layout.model_character_picture) {

        override fun ModelCharacterPictureBinding.bind() {
            Picasso.get().load(imageUrl).into(characterImage)
        }
    }

    // bind to model_character_data item fields
    data class DataPointEpoxyModel(
        val title: String,
        val description: String
    ) : ViewBindingKotlinModel<ModelCharacterDataBinding>(R.layout.model_character_data) {

        override fun ModelCharacterDataBinding.bind() {
            characterDataIl.hint = title
            characterDataEt.setText(description)
        }
    }
}