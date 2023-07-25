package com.example.postermpp.ui.screen

import com.example.postermpp.domain.model.ProductsModel
import com.example.postermpp.ui.components.FilterType

data class HomeState(
    val productsSuccess: List<ProductsModel> = emptyList(),
    val electroSuccess: List<ProductsModel> = emptyList(),
    val isLoading: Boolean = false,
    val selectedFilter: FilterType = FilterType.JEWELERY,
    val filteredProducts: List<ProductsModel> = emptyList()
)
