package com.example.postermpp.domain.repository

import com.example.postermpp.domain.model.ProductsModel
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface ProductsRepository {
   fun getProducts(): Flow<List<ProductsModel>>
   suspend fun getElectro():Result<List<ProductsModel>>
   suspend fun getFilterJel():Result<List<ProductsModel>>
   suspend fun getFilterMenClo():Result<List<ProductsModel>>
}