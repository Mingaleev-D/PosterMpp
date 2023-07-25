package com.example.postermpp.data.repository

import com.example.postermpp.data.ext.resultOf
import com.example.postermpp.data.local.ProductsDao
import com.example.postermpp.data.local.ProductsType
import com.example.postermpp.data.mapper.toDomain
import com.example.postermpp.data.mapper.toEntity
import com.example.postermpp.data.remote.ApiService
import com.example.postermpp.domain.model.ProductsModel
import com.example.postermpp.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

class ProductsRepositoryImpl(
    private val api: ApiService,
    private val dao: ProductsDao
) : ProductsRepository {

   override fun getProducts(): Flow<List<ProductsModel>> {
      return flow {
         val localProduct = dao.getProducts().filter { it.type == ProductsType.PRODUCTS }
         emit(localProduct.map { it.toDomain() })
         getProductsRemote().onSuccess {
            emit(it)
         }.onFailure {
            println()
         }
      }
   }

   private suspend fun getProductsRemote() = resultOf {
      val productResult = api.getProducts().map { it.toDomain() }
      productResult.forEach { dao.insertP(it.toEntity(ProductsType.PRODUCTS)) }
      productResult
   }


   override suspend fun getElectro() = resultOf {
      api.getElectroProducts().map { it.toDomain() }
   }

   override suspend fun getFilterJel() = resultOf {
      api.getFilterJewelery().map { it.toDomain() }
   }

   override suspend fun getFilterMenClo() = resultOf {
      api.getFiltermenClothing().map { it.toDomain() }

   }
}
