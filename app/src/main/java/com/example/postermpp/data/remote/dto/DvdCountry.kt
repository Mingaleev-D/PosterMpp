package com.example.postermpp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DvdCountry(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("timezone")
    val timezone: String
)