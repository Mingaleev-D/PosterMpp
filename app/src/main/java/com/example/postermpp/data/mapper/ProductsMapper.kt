package com.example.postermpp.data.mapper

import com.example.postermpp.data.local.ProductsEntity
import com.example.postermpp.data.local.ProductsType
import com.example.postermpp.data.remote.dto.ProductsDtoItem
import com.example.postermpp.domain.model.ProductsDetailModel
import com.example.postermpp.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

fun ProductsDtoItem.toDomain(): ProductsModel {
   return ProductsModel(
       id = this.id,
       title = this.title,
       image = this.image,


   )
}

fun ProductsModel.toEntity(type: ProductsType): ProductsEntity {
   return ProductsEntity(
       id = this.id,
       image = this.image,
       title = this.title,
       type = type
   )
}

fun ProductsEntity.toDomain(): ProductsModel {
   return ProductsModel(
       id = this.id,
       title = this.title,
       image = this.image,
   )
}

fun ProductsDtoItem.toDetailDomain(): ProductsDetailModel {
   return ProductsDetailModel(
       id = this.id,
       title = this.title,
       price = this.price,
       description = this.description,
       category = this.category,
       image = this.image,
       rating = this.rating.rate,

       )
}