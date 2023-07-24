package com.example.postermpp.data.mapper

import com.example.postermpp.data.remote.dto.ProductsDtoItem
import com.example.postermpp.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

fun ProductsDtoItem.toDomain(): ProductsModel {
   return ProductsModel(
       id = this.id,
       title = this.title,
       price = this.price,
       description = this.description,
       category = this.category,
       image = this.image,
       rating = this.rating.rate,

   )
}