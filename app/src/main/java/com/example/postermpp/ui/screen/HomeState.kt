package com.example.postermpp.ui.screen

import com.example.postermpp.domain.model.ProductsModel

data class HomeState(
    val productsSuccess:List<ProductsModel> = emptyList(),
    val electroSuccess:List<ProductsModel> = emptyList(),
    val isLoading:Boolean = false
)
