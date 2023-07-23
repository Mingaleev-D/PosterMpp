package com.example.postermpp.ui.screen

import com.example.postermpp.domain.model.TvShowModel

data class HomeState(
    val showSuccess:List<TvShowModel> = emptyList(),
    val isLoading:Boolean = false
)
