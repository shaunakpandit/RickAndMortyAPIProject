package com.example.cloverassessment.epoxy

import com.example.cloverassessment.R
import com.example.cloverassessment.databinding.ModelLoadingBinding

/*
Manages Loading screen view
 */

class LoadingEpoxyModel : ViewBindingKotlinModel<ModelLoadingBinding>(R.layout.model_loading) {

    override fun ModelLoadingBinding.bind() {
        // nothing to do
    }

    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}