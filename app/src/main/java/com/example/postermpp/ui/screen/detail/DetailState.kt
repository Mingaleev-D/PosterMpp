package com.example.postermpp.ui.screen.detail

import com.example.postermpp.domain.model.ProductsDetailModel

data class DetailState(
    val products: ProductsDetailModel? = null,
    val isLoading: Boolean = false
)
