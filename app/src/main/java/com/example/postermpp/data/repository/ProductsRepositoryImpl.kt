package com.example.postermpp.data.repository

import com.example.postermpp.data.ext.resultOf
import com.example.postermpp.data.mapper.toDomain
import com.example.postermpp.data.remote.ApiService
import com.example.postermpp.domain.model.ProductsModel
import com.example.postermpp.domain.repository.ProductsRepository

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

class ProductsRepositoryImpl(
    private val api: ApiService
) : ProductsRepository {

   override suspend fun getProducts() =resultOf {
      api.getProducts().map { it.toDomain() }
   }

   override suspend fun getElectro() =resultOf {
      api.getElectroProducts().map { it.toDomain() }
   }

   override suspend fun getFilterJel() = resultOf {
      api.getFilterJewelery().map { it.toDomain() }
      }

   override suspend fun getFilterMenClo() = resultOf {
      api.getFiltermenClothing().map { it.toDomain() }

   }
}
