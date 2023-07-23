package com.example.postermpp.domain.model

data class TvShowModel(
    val id: Int,
    val name: String,
    val genres: List<String>,
    val rating: Double,
    val image: String,
    val summary: String,
    val premiered: String

)
