package com.example.postermpp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self,
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode,
    @SerializedName("nextepisode")
    val nextepisode: Nextepisode
)