package com.example.dipeshlamaarchitectureassignment.feature.shared.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse {

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("poster")
    @Expose
    val poster: String? = null

    @SerializedName("year")
    @Expose
    val year: String? = null
}