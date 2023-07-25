package com.example.postermpp.domain.repository

import com.example.postermpp.domain.model.ProductsDetailModel
import com.example.postermpp.domain.model.ProductsModel
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface ProductsRepository {
   fun getProducts(): Flow<List<ProductsModel>>
   fun getElectro():Flow<List<ProductsModel>>
   fun getFilterJel():Flow<List<ProductsModel>>
   fun getFilterMenClo():Flow<List<ProductsModel>>

   suspend fun getProductsById(id:Int):Result<ProductsDetailModel>
}