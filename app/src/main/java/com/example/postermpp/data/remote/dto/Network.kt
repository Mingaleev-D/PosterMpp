package com.example.postermpp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: Country,
    @SerializedName("officialSite")
    val officialSite: String
)