package com.example.postermpp.domain.model

data class ProductsDetailModel(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Double
)
