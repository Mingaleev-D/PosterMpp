package com.example.postermpp.ui.screen

import com.example.postermpp.ui.components.FilterType

sealed class HomeEvent{
   data class ChangeFilter(val filterType: FilterType):HomeEvent()
   data class OnProductsClick(val productId:Int):HomeEvent()
}
