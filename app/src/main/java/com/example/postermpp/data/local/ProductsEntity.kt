package com.example.postermpp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class ProductsEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val image: String,
    val type: ProductsType
)

enum class ProductsType {
   PRODUCTS,
   ELECTRO,
   JEL,
   MENSCLO
}
