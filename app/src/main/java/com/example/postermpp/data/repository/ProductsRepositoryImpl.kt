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


   override fun getElectro(): Flow<List<ProductsModel>> {
      return flow {
         val localElectro = dao.getProducts().filter { it.type == ProductsType.ELECTRO }
         emit(localElectro.map { it.toDomain() })
         getElectroRemote().onSuccess {
            emit(it)
         }.onFailure {
            println()
         }
      }
   }

   private suspend fun getElectroRemote() = resultOf {
      val eloctroResult = api.getElectroProducts().map { it.toDomain() }
      eloctroResult.forEach { dao.insertP(it.toEntity(ProductsType.ELECTRO)) }
      eloctroResult
   }

   override fun getFilterJel(): Flow<List<ProductsModel>> {
      return flow {
         val localJet = dao.getProducts().filter { it.type == ProductsType.JEL }
         emit(localJet.map { it.toDomain() })
         getFilterJelRemote().onSuccess {
            emit(it)
         }.onFailure {
            println()
         }
      }
   }

   private suspend fun getFilterJelRemote() = resultOf {
      val filterJetResult = api.getFilterJewelery().map { it.toDomain() }
      filterJetResult.forEach { dao.insertP(it.toEntity(ProductsType.JEL)) }
      filterJetResult
   }

   override fun getFilterMenClo(): Flow<List<ProductsModel>> {
      return flow {
         val localMenClo = dao.getProducts().filter { it.type == ProductsType.MENSCLO }
         emit(localMenClo.map { it.toDomain() })
         getFilterMenCloRemote().onSuccess {
            emit(it)
         }.onFailure {
            println()
         }
      }
   }
   private suspend fun getFilterMenCloRemote() = resultOf {
      val menCloResult = api.getFiltermenClothing().map { it.toDomain() }
      menCloResult.forEach { dao.insertP(it.toEntity(ProductsType.MENSCLO)) }
      menCloResult
   }

   }

